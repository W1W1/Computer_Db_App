/** 
 * @author Richard Dartus & Alexandre Woindrich
 * @since 06/09/2016
 * @version 1.0
 */

package Views;

import java.util.ArrayList;
import Util.Company;
import java.sql.*;

public class Views_Listing_Companies {
	/**
	 * Arraylist containing the list of companies to be used
	 */
	private static ArrayList<Company> companyArraylist = new ArrayList<>();
	
	public Views_Listing_Companies(){	}
	
	public Views_Listing_Companies(ArrayList companyArraylist){
		this.companyArraylist = companyArraylist;
	}
	
	/**
	 * Lists companies contained in the Arraylist in the console
	 */
	public void afficher(){
		for(Company company : companyArraylist){
			System.out.println(company.toString());
		}
	}
	
	/**
	 * Imports list from local sql server
	 */
	public void importSqlData(){
		long id;
		String name;
		
		String url = "jdbc:mysql://localhost:3306/bdd_computer_company";
		String usr = "root";
		String pass = "";
		
		try{
			Class.forName( "com.mysql.jdbc.Driver" );
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			Connection cn = DriverManager.getConnection(url, usr, pass);
			System.out.println("Connection successful!");
			
			Statement st= cn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM company");
			
			while (rs.next()){
				
				companyArraylist.add(new Company(rs.getInt("id"),rs.getString("name")));
				
			}
			
			st.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
