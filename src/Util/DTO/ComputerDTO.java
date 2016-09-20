package Util.DTO;

import Util.Company;
import Util.Computer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Richard Dartus & Alexandre Woindrich
 * @since 06/09/2016
 * @version 1.0
 */
public class ComputerDTO {
    /**
     * Computer DTO utilisé pour formatter un Computer pour son affichage.
     * La date notament est changer pour son affichage dans l'HTML.
     * Permet un code DRY dans les JSP.
     *
     * Possède les mêmes get/set
     * Changementau niveau du Constructeur.
     */

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        private long id;
        private String name;
        private String introduced;
        private String discontinued;
        private Company company;

        public ComputerDTO() {

        }

        public ComputerDTO(Computer computer) {
            this.id = computer.getId();
            this.name = computer.getName();
            this.introduced = computer.getIntroduced()!=null?sdf.format(computer.getIntroduced()):"";
            this.discontinued = computer.getDiscontinued()!=null?sdf.format(computer.getDiscontinued()):"";
            this.company = computer.getCompany();
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getIntroduced() {
            return introduced;
        }

        public void setIntroduced(String introduced) {this.introduced=introduced;}

        public String getDiscontinued() {
            return discontinued;
        }

        public void setDiscontinued(String discontinued) {
            this.discontinued = discontinued;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }


        @Override
        public String toString() {
            return "id : "+id+"\n"
                    +"name : "+name+"\n"+
                    "introduced : "+introduced +"\n"+
                    "discontinued : " + discontinued +"\n"+"------------------"+"\n"+
                    "company : " + company+"\n\n";
        }
    }
