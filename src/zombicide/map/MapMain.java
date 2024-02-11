package zombicide.map;

import java.util.*;

import zombicide.map.cell.*;
import zombicide.map.cell.room.*;
import zombicide.map.grid.Grid;
import zombicide.map.util.*;


public class MapMain {
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bonjpur, vous êtes sur le point de construire votre grille de jeu.");
        System.out.println("De quel taille souhaitez vous que votre plateau de jeu soit?");
        System.out.print("Choisissez la largeur : ");
        int weightOfMap = scanner.nextInt();
        System.out.print("Choisissez la hauteur : ");
        int heitghOfMap = scanner.nextInt();
        System.out.print("Choissisez la largeur de vos cellules (Un conseil prenez un nombre grand pour une meilleure visibilité) :  ");
        int weightOfCells = scanner.nextInt();

        Map map = new Map(weightOfMap,heitghOfMap);
        Grid grid= new Grid(map, weightOfCells);

        System.out.println("Voici à qoi ressemble votre plateau:");
        grid.displayGrid();

    }
} 