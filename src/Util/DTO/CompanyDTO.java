package Util.DTO;


import Util.Company;

import java.util.ArrayList;


/**
 * @author Richard Dartus & Alexandre Woindrich
 * @since 06/09/2016
 * @version 1.0
 */

public class CompanyDTO {
    /**
     * LEGACY CODE :
     * Proof of Concept pour afficher le nombre d'ordinateur de l'entreprise.
     * Abandonné par manque de moyen performant de récupération de ce nombre.
     */
    private long id;
    private String name;
    private int nbComputer;

    public CompanyDTO(Company company, int nbComputer) {
        this.id = company.getId();
        this.name = company.getName();
        this.nbComputer = nbComputer;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "id : " + id +"\n"
                +"name : "+name + "\n";
    }
}
