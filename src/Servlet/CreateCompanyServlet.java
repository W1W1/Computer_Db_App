package Servlet;

import Util.Company;
import Util.Forms.CreateCompanyForm;
import Util.SQLConnection.ManageCompany;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by  Woindrich on 08/09/2016.
 */
public class CreateCompanyServlet extends HttpServlet {

    public static final String ATT_COMPANY = "company";
    public static final String ATT_FORM     = "form";

    public static final String VUE_SUCCES   = "/WEB-INF/getCommande.jsp";
    public static final String VUE_FORM     = "/WEB-INF/createCompany.jsp";


    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        /* Préparation de l'objet formulaire */
        CreateCompanyForm form = new CreateCompanyForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Company company = form.createCompany( request );

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_COMPANY, company );
        request.setAttribute( ATT_FORM, form );


        if ( form.getErreurs().isEmpty() ) {
            /* Si aucune erreur, alors input de l'entrep affichage de la fiche récapitulative */
            ManageCompany.addCompany(company);
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }








    public void doPostOLDVERSION(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Company company = new Company();

        String name = request.getParameter( "companyName" );

        String message;

        if (  name.trim().isEmpty() ) {
            message = "Erreur - Veuillez donner un nom à l'entreprise à créer <br> <a href=\"createCompany.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'une entreprise.";
        } else {
            message = "Entreprise créé avec succès !";
        }

        company.setName(name);

        request.setAttribute( "company", company );
        request.setAttribute( "message", message );

        ManageCompany.addCompany(company);

        this.getServletContext().getRequestDispatcher( "/WEB-INF/getCompany.jsp" ).forward( request, response );
    }
}

