/** 
 * @author Richard Dartus & Alexandre Woindrich
 * @since 06/09/2016
 * @version 1.0
 */

package Views;
import Util.Company;
import Util.Computer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Richard-DT on 06/09/2016.
 */
public class Views_Listing {
    private static ArrayList<Computer> computerArrayList = new ArrayList<>();

    public Views_Listing() {
    }

    public static ArrayList<Computer> getComputerArrayList() {
        return computerArrayList;
    }

    public static void setComputerArrayList(ArrayList<Computer> computerArrayList) {
        Views_Listing.computerArrayList = computerArrayList;
    }

    /**
     *
     */

    public void utilisation(int page, int nbElements){
        boolean end =false;
        do {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println("page ? :");
                page = sc.nextInt();
                end = page-1>=0&&page*nbElements <= computerArrayList.size()?false:true;
                afficher(page, nbElements);
            }catch (InputMismatchException ime){
                end = true;
            }
        }while (!end);
    }

    public void afficher(){
        for (Computer computer:computerArrayList) {
            System.out.println(computer.toString());
        }
    }
    public void afficher(int page,int nbElements){
        int i;
        if(page*nbElements <= computerArrayList.size()){
            //page commencent à 1 alors qu'index 0
            //
            for (i=(page-1)*nbElements;i<page*nbElements;i++) {
                Computer computer = computerArrayList.get(i);
                System.out.println(computer.toString());
            }
        }
    }
}
