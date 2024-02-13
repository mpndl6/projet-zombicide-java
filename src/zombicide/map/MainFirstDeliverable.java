package zombicide.map;

import java.util.*;

import grid.Grid;


public class MainFirstDeliverable {
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
            Map map = new Map(weightOfMap,heitghOfMap);
            Grid grid= new Grid(map, weightOfCells);

            System.out.println("Voici à qoi ressemble votre plateau:");
            grid.displayGrid();
        }
        catch (InputMismatchException e){
        System.out.println("Merci d'entrer une valeur correcte");
    }
} }