package Util.Forms;

import Util.Computer;
import Util.Company;
import Util.SQLConnection.ManageCompany;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alex on 9/8/2016.
 */
public class CreateComputerForm {

    private static final String CHAMP_NAME = "computerName";
    private static final String CHAMP_COMPANY_NAME = "companyName";
    private static final String CHAMP_INTRODUCED = "introduced";
    private static final String CHAMP_DISCONTINUED = "discontinued";
    private String              resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Computer createComputer( HttpServletRequest request ) {
        CreateComputerForm computerForm = new CreateComputerForm();

        erreurs = computerForm.getErreurs();

        String name = getValeurChamp( request, CHAMP_NAME );
        String company_id = getValeurChamp( request, CHAMP_COMPANY_NAME );
        String introduced = getValeurChamp( request, CHAMP_INTRODUCED );
        String discontinued = getValeurChamp( request, CHAMP_DISCONTINUED );

        Computer computer = new Computer();
        Company company = new Company();
        Company lookup = new Company();

        try {
            validationName( name );
        } catch ( Exception e ) {
            setErreur( CHAMP_NAME, e.getMessage() );
        }
        computer.setName( name );

        try {
            validationCompanyName( company_id );
        } catch ( Exception e ) {
            setErreur( CHAMP_COMPANY_NAME, e.getMessage() );
        }

        company = ManageCompany.getCompany(Integer.valueOf(company_id));

        computer.setCompany(company);

        try {
            computer.setIntroduced(introduced);
        } catch (Exception e) {
            setErreur( CHAMP_INTRODUCED, e.getMessage() );
        }
        try {
            computer.setDiscontinued(discontinued);
        } catch (Exception e) {
            setErreur( CHAMP_DISCONTINUED, e.getMessage() );
        }

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création de l'entreprise.";
        } else {
            resultat = "Échec de la création de l'entreprise.";
        }

        return computer;
    }

    private void validationName( String name ) throws Exception {
        if ( name == null ) {
            throw new Exception( "Veuillez saisir un nom pour l'ordinateur." );
        }
    }

    private void validationCompanyName( String name ) throws Exception {
        if ( name == null ) {
            throw new Exception( "Veuillez entrer une entreprise." );
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
