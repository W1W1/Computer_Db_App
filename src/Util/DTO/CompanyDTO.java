package Util.DTO;


import Util.Company;

import java.util.ArrayList;

/**
 * Created by Richard-DT on 14/09/2016.
 */
public class CompanyDTO {
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
