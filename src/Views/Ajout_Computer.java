package Views;

import Util.Computer;
import Util.SQLConnection.SqlData;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Richard-DT on 06/09/2016.
 */
public class Ajout_Computer {
    public Ajout_Computer() {
    }

    public void utilisation() {
        boolean end = false;
        Computer computer = new Computer();
        Scanner sc = new Scanner(System.in);
        System.out.println("id :");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("name :");
        String name = sc.nextLine();
        System.out.println("introduced :");
        System.out.println("année :");
        int year1 = sc.nextInt();
        System.out.println("mois :");
        int month1 = sc.nextInt();
        System.out.println("jour :");
        int day1 = sc.nextInt();
        System.out.println("discontinued :");
        System.out.println("année :");
        int year2 = sc.nextInt();
        System.out.println("mois :");
        int month2 = sc.nextInt();
        System.out.println("jour :");
        int day2 = sc.nextInt();
        Date date1 = new Date(year1-1900,month1,day1);
        //date1.setDate(day1);
        //date1.setMonth(month1);
        //date1.setYear(year1);
        Date date2 = new Date(year2-1900,month2,day2);
        //date2.setDate(day2);
        //date2.setMonth(month2);
        //date2.setYear(year2);
        computer.setId(id);
        computer.setName(name);
        computer.setIntroduced(date1);
        computer.setDiscontinued(date2);
        SqlData.AddComputer(computer);
    }

}
