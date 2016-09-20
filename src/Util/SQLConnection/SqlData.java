package Util.SQLConnection;

import Util.Company;
import Util.Computer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


/**
 * LEGACY CODE:
 * Code à utiliser si Hibernate n'est pas intégré,
 * Code d'aprentissage.
 */
public class SqlData {
	private static String URL = "jdbc:mysql://localhost:3306/computer-database-db";
	private static String USR = "root";
	private static String PASS = "";
	
	
	
	public static Computer GetComputer(long id) throws ParseException{
		
		Computer computer = new Computer();
		
		try{
			Class.forName( "com.mysql.jdbc.Driver" );
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			Connection cn = DriverManager.getConnection(URL, USR, PASS);
			System.out.println("Connection successful!");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Calendar cIntroduced = null;
			Calendar cDiscontinued = null;
			
			Statement st= cn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM computer WHERE id="+id);
			rs.next();
			
			computer.setId(rs.getInt("id"));
			
			computer.setName(rs.getString("name"));
			
			if(rs.getString("introduced")!=null)
			{
				computer.setIntroduced(sdf.parse(rs.getString("introduced")));
			}
			
			if(rs.getString("discontinued")!=null)
			{
				computer.setDiscontinued(sdf.parse(rs.getString("discontinued")));
			}
			
			
			ResultSet rs_comp = st.executeQuery("SELECT * FROM company WHERE id="+rs.getInt("company_id"));
			rs_comp.next();
			
			computer.setCompany(new Company(rs_comp.getInt("id"),rs_comp.getString("name")));
			
			st.close();
			cn.close();
			
			return computer;
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return computer;
		
		
	}
	
public static void AddComputer(Computer computer){
		
		try{
			Class.forName( "com.mysql.jdbc.Driver" );
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			Connection cn = DriverManager.getConnection(URL, USR, PASS);
			System.out.println("Connection successful!");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Calendar cIntroduced = null;
			Calendar cDiscontinued = null;
			
			Statement st= cn.createStatement();
			
			int rs;
			String statement;

			if(computer.getCompany()==null){
				statement = "INSERT INTO `computer`(`name`, `introduced`, `discontinued`, `company_id`) VALUES ('"+computer.getName()+"','"+sdf.format(computer.getIntroduced())+"','"+sdf.format(computer.getDiscontinued())+"',null)";
			//"+computer.getId()+",
			//
			}else{
				statement = "INSERT INTO `computer`(`id`, `name`, `introduced`, `discontinued`, `company_id`) VALUES (["+computer.getId()+"],["+computer.getName()+"],["+sdf.format(computer.getIntroduced())+"],["+sdf.format(computer.getDiscontinued())+"],["+computer.getCompany().getId()+"])";
			}
			System.out.println(statement);
			rs = st.executeUpdate(statement);
			
			st.close();
			cn.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
