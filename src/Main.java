/** 
 * @author Richard Dartus & Alexandre Woindrich
 * @since 06/09/2016
 * @version 1.0
 */


import Util.*;
import Util.SQLConnection.ManageCompany;
import Util.SQLConnection.ManageComputer;
import Util.SQLConnection.SqlData;
import Views.Ajout_Computer;
import Views.VIew_Menu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Main {
	
	/**
	 * Main method, console
	 * 
	 * @param args
	 */
	
	public static void main(String[] args){

		ArrayList<Computer> computers = (ArrayList)ManageComputer.listComputer();
		for (Computer comp :
				computers) {
			System.out.println(comp);
		}
		Computer cpu;
		try {
			cpu = SqlData.GetComputer(1);
			System.out.println(cpu);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ManageCompany.listCompany();
		ManageCompany.searchCompany("a");
		Ajout_Computer aj = new Ajout_Computer();
		aj.utilisation();

	}
}
