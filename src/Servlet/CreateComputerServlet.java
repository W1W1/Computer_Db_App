package Servlet;


import Util.Company;
import Util.Computer;
import Util.Forms.CreateComputerForm;
import Util.SQLConnection.ManageCompany;
import Util.SQLConnection.ManageComputer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alex on 9/8/2016.
 */
public class CreateComputerServlet extends HttpServlet {
    public static final String ATT_COMPUTER = "computer";
    public static final String ATT_FORM     = "form";

    public static final String VUE_SUCCES   = "/getComputer";
    public static final String VUE_FORM     = "/WEB-INF/createComputer.jsp";


    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
        List<Company> companies = ManageCompany.listCompany();

        request.setAttribute("companies",companies);

        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        /* Préparation de l'objet formulaire */
        CreateComputerForm form = new CreateComputerForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Computer computer = form.createComputer( request );

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_COMPUTER, computer );
        request.setAttribute( ATT_FORM, form );


        if ( form.getErreurs().isEmpty() ) {
            /* Si aucune erreur, alors input de l'entrep affichage de la fiche récapitulative */
            ManageComputer.addComputer(computer);
            long id = ManageComputer.getLastComputerId();
            response.sendRedirect(request.getContextPath() + VUE_SUCCES +"?"+"id="+id);
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}
