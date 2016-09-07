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
		ArrayList<Computer> computerArrayList = new ArrayList<>();
		Computer computer1 = new Computer(1,"blbl1", new Date(),new Date(), new Company());
		computerArrayList.add(computer1);
		Computer computer2 = new Computer(2,"blbl2", new Date(),new Date(), new Company());
		computerArrayList.add(computer2);
		VIew_Menu menu= new VIew_Menu();
		boolean end =false;
//		do {
//			try {
//				menu.printMenu();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			Scanner sc = new Scanner(System.in);
//			sc.nextLine();
//
//		}while (!end);
		
		Computer cpu;
		try {
			cpu = SqlData.GetComputer(1);
			System.out.println(cpu);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ManageComputer.listComputer();
		ManageCompany.listCompany();
		ManageCompany.searchCompany("a");
		Ajout_Computer aj = new Ajout_Computer();
		aj.utilisation();

	}
}
