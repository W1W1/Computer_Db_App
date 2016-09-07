/** 
 * @author Richard Dartus & Alexandre Woindrich
 * @since 06/09/2016
 * @version 1.0
 */

package Views;

import Util.Company;
import Util.Computer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Richard-DT on 06/09/2016.
 */
public class VIew_Menu {
    ArrayList<Computer> computerArrayList = new ArrayList<>();

    Views_Listing listing_computer = new Views_Listing();
    Ajout_Computer ajout_computer = new Ajout_Computer();
    Views_Listing_Companies listing_companies = new Views_Listing_Companies();
    public VIew_Menu() {
    }

    public void printMenu() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Lister ordinateur : 1");
        System.out.println("ajouter ordinateur: 2");
        System.out.println("supprimer ordinateur: 3");
    }

    public boolean choice(int i){
        switch (i){
            case 1:{
                Computer computer1 = new Computer(1, "blbl1",new Date(),new Date(), new Company());
                computerArrayList.add(computer1);
                Computer computer2 = new Computer(2, "blbl2",new Date(),new Date(), new Company());
                computerArrayList.add(computer2);
                listing_computer.setComputerArrayList(computerArrayList);
                listing_computer.utilisation(1,1);
                return false;
            }
            case 2:{
                ajout_computer.utilisation();
                return false;
            }
            case 3:{
                listing_companies.importSqlData();
                listing_companies.afficher();
            }
            default:
                return true;
        }
    }
}
