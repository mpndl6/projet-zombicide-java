package zombicide;

import java.util.*;

import zombicide.map.Map;
import zombicide.map.cell.*;

import grid.Grid;
import zombicide.map.cell.room.Continental;
import zombicide.map.cell.room.DrugStore;


public class Livrable1 {
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Bonjour, vous êtes sur le point de construire votre grille de jeu.");
            System.out.println("De quel taille souhaitez vous que votre plateau de jeu soit?");
            System.out.print("Choisissez la largeur (>=5) : ");
            int weightOfMap = scanner.nextInt();
            System.out.print("Choisissez la hauteur (>=5): ");
            int heitghOfMap = scanner.nextInt();
            System.out.println("Choissisez la largeur de vos cellules");
            System.out.print("Un conseil prenez un nombre grand pour une meilleure visibilité) :");
            int weightOfCells = scanner.nextInt();

            List<Cell> listrooms = new ArrayList<Cell>();
            List<Cell> liststreets = new ArrayList<Cell>();

            liststreets.add(new StreetWW());


            System.out.println("nb continantal?");
            int nbC = scanner.nextInt();
            for(int i = nbC ; i > 0 ; i--) {
                listrooms.add(new Continental());
            }
            System.out.println("nb D?");
            int nbD = scanner.nextInt();
            for(int i = nbD ; i > 0 ; i--) {
                listrooms.add(new DrugStore());
            }

            zombicide.map.Map map = new Map(weightOfMap,heitghOfMap,listrooms,liststreets);
            Grid grid= new Grid(map, weightOfCells);

            System.out.println("Voici à qoi ressemble votre plateau:");
            grid.displayGrid();
        }
        catch (InputMismatchException e){
        System.out.println("Merci d'entrer une valeur correcte");
    }
} }