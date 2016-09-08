package Util.Forms;

import Util.Company;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alex on 9/8/2016.
 */
public class CreateCompanyForm {

    private static final String CHAMP_NAME = "companyName";
    private String              resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Company createCompany( HttpServletRequest request ) {
        CreateCompanyForm companyForm = new CreateCompanyForm();

        erreurs = companyForm.getErreurs();

        String name = getValeurChamp( request, CHAMP_NAME );

        Company company = new Company();

        try {
            validationName( name );
        } catch ( Exception e ) {
            setErreur( CHAMP_NAME, e.getMessage() );
        }

        company.setName( name );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création de l'entreprise.";
        } else {
            resultat = "Échec de la création de l'entreprise.";
        }

        return company;

    }

    private void validationName( String name ) throws Exception {
        if ( name == null ) {
            throw new Exception( "Merci d'entrer un mode de paiement." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
