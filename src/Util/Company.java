/** 
 * @author Richard Dartus & Alexandre Woindrich
 * @since 06/09/2016
 * @version 1.0
 */

package Util;


import javax.persistence.*;

@Entity
@Table(name = "Company")
public class Company {
	
	/**
	 * Company id
	 */

	@Id

	@Column(name = "id")
	private long id;
	/**
	 * Company name
	 */
	@Column(name = "name")
	private String name;
	
	public Company(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Company() {}


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
