/** 
 * @author Richard Dartus & Alexandre Woindrich
 * @since 06/09/2016
 * @version 1.0
 */

package Util;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


@Entity
@Table(name = "Computer")
public class Computer {

	@Id
	@Column(name = "id")
	private long id;
	@Column (name = "name")
	private String name;
	@Column (name = "introduced")
	private Date introduced;
	@Column (name = "discontinued")
	private Date discontinued;
    @ManyToOne
	@JoinColumn (name = "company_id")
	private Company company;

    public Computer() {

	}

	public Computer(long id, String name, Date introduced, Date discontinued, Company company) {
		this.id = id;
        this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company = company;
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

	public Date getIntroduced() {
		return introduced;
	}

	public void setIntroduced(Date introduced) {this.introduced=introduced;}
	public void setIntroduced(String introduced) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            this.introduced = sdf.parse(introduced);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

	public Date getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Date discontinued) {
		this.discontinued = discontinued;
	}
	public void setDiscontinued(String discontinued) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            this.discontinued = sdf.parse(discontinued);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
