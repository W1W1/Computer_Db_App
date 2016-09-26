package Servlet;

import Util.Computer;
import Util.DTO.ComputerDTO;
import Util.SQLConnection.ManageComputer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richard-DT on 07/09/2016.
 */

public class ListComputerServlet extends HttpServlet {
    public final static int PAGE = 1;
    public final static int NB_ELEMENTS = 25;

    /**
     * public void doGet : Permet de récupérer les éléments nécessaires au bon affichage de la liste des ordinateurs:
     *                          * la liste des ordinateurs comprise dans la base de donnée, OU
     *                          * la liste des ordinateurs correspondant au résultat d'une recherche
     *                          * un message d'erreur si une recherche ne présente aucun résultat
     *                          * le nombre d'éléménts à afficher par page
     *                          * le numéro de la page a afficher
     *                     Revoie sur la page de liste d'ordinateurs lorsque celle-ci est appelée
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int nbElements = NB_ELEMENTS;
        int page = PAGE;
        String searchEmpty = "Pas d'ordinateurs trouvés sous ce nom.";
        List<Computer> computers;

        if (request.getParameter("page") != null
                && !request.getParameter("page").equals("")) {
            page = Integer.valueOf(request.getParameter("page"));
        }
        if (request.getParameter("nbElements") != null
                && !request.getParameter("nbElements").equals("")) {
            nbElements = Integer.valueOf(request.getParameter("nbElements"));
        }
        if (request.getParameter("sE") == null) {
            searchEmpty = "";
        }
        if (request.getParameter("result") == null) {
            computers = ManageComputer.listComputer(nbElements, page);
        }
        else
        {
            computers = ManageComputer.searchComputer(request.getParameter("result"));
        }

        ArrayList<ComputerDTO> computerDTOs = new ArrayList<>();


        if (computers != null) {
            for (Computer computer :
                    computers) {
                computerDTOs.add(new ComputerDTO(computer));
            }
        }

        request.setAttribute("page", page);
        request.setAttribute("nbElements", nbElements);
        request.setAttribute("computers", computerDTOs);
        request.setAttribute("searchEmpty", searchEmpty);
        this.getServletContext().getRequestDispatcher("/WEB-INF/listComputer.jsp").forward(request, response);
    }

    /**
     * public void doPost : selon le formulaire appelé, cette méthode:
     *                          * Modifiera la pagination de la page en changeant le nombre d'éléments par page et/ou
     *                            la page selectionnée
     *                          * effectuera la gestion de la recherche d'un ordinateur, en renvoyant des résultats
     *                            selon si la recherche renvoie aucun, un, ou plusieurs résultats
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            String url = String.format(request.getContextPath() + "/listComputer?page=%d&nbElements=%d", page, nbElements);
            response.sendRedirect(url);
        }else if(form.equals("search")){
            //si la barre de recherche est vide, ne rien faire

            String searchMe = request.getParameter("searchMe");

            System.out.println("item searched : \"" + searchMe + "\"");

            if (searchMe.equals("")){
                String url = String.format(request.getContextPath() + "/listComputer?page=%d&nbElements=%d", page, nbElements);
                response.sendRedirect(url);
            }

            //Recherche d'ordinateurs
            List<Computer> searchResults;
            searchResults = ManageComputer.searchComputer(searchMe);

            //gestion du résultat obtenu
            if (searchResults.size() != 0) //il y a au moins un résultat
            {
                if (searchResults.size() == 1) //il y a un résultat
                {
//                    String url = request.getContextPath() + "/getComputer?id="+ searchResults.get(0).getId();
                    String url = String.format((request.getContextPath() + "/getComputer?id=%d"), searchResults.get(0).getId());
                    response.sendRedirect(url);
                }
                else //il y a plus d'un résultat
                {
                    String url = String.format(request.getContextPath() + "/listComputer?page=%d&nbElements=%d&result=%s", 1, nbElements,searchMe);
                    response.sendRedirect(url);
                }
            }
            else //pas de résultats: renvoyer sur la liste avec flag pour message d'erreur
            {
                String url = String.format(request.getContextPath() + "/listComputer?page=%d&nbElements=%d&sE=%s", page, nbElements,"y");
                response.sendRedirect(url);
            }


        }
    }

}
