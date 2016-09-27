package Servlet;

import Util.Company;
import Util.DTO.CompanyDTO;
import Util.DTO.ComputerDTO;
import Util.SQLConnection.ManageCompany;
import Util.SQLConnection.ManageComputer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 9/9/2016.
 */
public class ListCompanyServlet extends HttpServlet {
    public final static int PAGE = 1;
    public final static int NB_ELEMENTS= 50;

    /**
     * public void doGet : Permet de récupérer les éléments nécessaires au bon affichage de la liste des entreprises:
     *                          * la liste des entreprises comprise dans la base de donnée, OU
     *                          * la liste des entreprises correspondant au résultat d'une recherche
     *                          * un message d'erreur si une recherche ne présente aucun résultat
     *                          * le nombre d'éléménts à afficher par page
     *                          * le numéro de la page a afficher
     *                     Revoie sur la page de liste d'entreprises lorsque celle-ci est appelée
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nbElements = NB_ELEMENTS;
        int page = PAGE;
        String searchEmpty = "Pas d'entreprises trouvées sous ce nom.";
        List<Company> companies;

        if(request.getParameter("page")!=null
                && !request.getParameter("page").equals("")) {
            page = Integer.valueOf(request.getParameter("page"));
        }
        if(request.getParameter("nbElements")!=null
                && !request.getParameter("nbElements").equals("")) {
            nbElements = Integer.valueOf(request.getParameter("nbElements"));
        }
        if (request.getParameter("sE") == null) {
            searchEmpty = "";
        }
        if (request.getParameter("result") == null) {
            companies = ManageCompany.listCompany(nbElements,page);
        }
        else
        {
            companies = ManageCompany.searchCompany(request.getParameter("result"));
        }

//        ArrayList<CompanyDTO> companyDTOs = new ArrayList<>();
//        for (Company company:companies){
//            companyDTOs.add(new CompanyDTO(company,ManageCompany.nbComputer(company.getId())));
//        }


        request.setAttribute("page",page);
        request.setAttribute("nbElements",nbElements);
        request.setAttribute("companies",companies);
        request.setAttribute("searchEmpty", searchEmpty);
        this.getServletContext().getRequestDispatcher("/WEB-INF/listCompany.jsp").forward(request, response);
    }

    /**
     * public void doPost : selon le formulaire appelé, cette méthode:
     *                          * Modifiera la pagination de la page en changeant le nombre d'éléments par page et/ou
     *                            la page selectionnée
     *                          * effectuera la gestion de la recherche d'une entreprise, en renvoyant des résultats
     *                            selon si la recherche renvoie aucun, un, ou plusieurs résultats
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String form=request.getParameter("form_use");

        int page = PAGE;
        if (request.getParameter("page") != null &&
                !request.getParameter("page").equals("")) {
            page = Integer.valueOf(request.getParameter("page"));
        }
        int nbElements = NB_ELEMENTS;
        if (request.getParameter("nbElements") != null &&
                !request.getParameter("nbElements").equals("")) {
            nbElements = Integer.valueOf(request.getParameter("nbElements"));
        }

        if(form.equals("pagination")){
            String url= String.format(request.getContextPath() + "/listCompany?page=%d&nbElements=%d",page,nbElements);
            response.sendRedirect(url);
        }else if(form.equals("search")){
            String searchMe = request.getParameter("searchMe");

            System.out.println("item searched : \"" + searchMe + "\"");

            if (searchMe.equals("")){
                String url = String.format(request.getContextPath() + "/listCompany?page=%d&nbElements=%d", page, nbElements);
                response.sendRedirect(url);
            }

            //Recherche d'entreprises
            List<Company> searchResults;
            searchResults = ManageCompany.searchCompany(searchMe);

            if (searchResults.size() != 0) //il y a au moins un résultat
            {
                if (searchResults.size() == 1) //il y a un résultat
                {
//                    String url = request.getContextPath() + "/getComputer?id="+ searchResults.get(0).getId();
                    String url = String.format((request.getContextPath() + "/getCompany?id=%d"), searchResults.get(0).getId());
                    response.sendRedirect(url);
                }
                else //il y a plus d'un résultat
                {
                    String url = String.format(request.getContextPath() + "/listCompany?page=%d&nbElements=%d&result=%s", 1, nbElements,searchMe);
                    response.sendRedirect(url);
                }
            }
            else //pas de résultats: renvoyer sur la liste avec flag pour message d'erreur
            {
                String url = String.format(request.getContextPath() + "/listCompany?page=%d&nbElements=%d&sE=%s", page, nbElements,"y");
                response.sendRedirect(url);
            }

        }


    }
}