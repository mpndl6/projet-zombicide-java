package zombicide.map;
import grid.Grid;
import zombicide.actor.survivors.Survivor;
import zombicide.actor.survivors.type.Fighter;
import zombicide.actor.survivors.type.Healer;
import zombicide.actor.survivors.type.Lucky;
import zombicide.actor.survivors.type.Nosy;

import java.util.*;


public class Livrable2 {
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        //Ville d'entraienement :
        int weightOfMap= 5;
        int heightOfMap=5;
        int weightOfCells=5;

        Map map = new Map(weightOfMap,heightOfMap);
        Grid grid = new Grid(map,weightOfCells);
        grid.displayGrid();

        Survivor survivor1 = new Healer("Dr.Dre");
        Survivor survivor2 = new Nosy("snoop");
        Survivor survivor3= new Fighter("Meek");
        Survivor survivor4 = new Lucky("zz");


        // En attendant la création des utilitaires (Ajout de la carte dans le backpack + de la fiole dans la main:
        /** Item carte= new Carte();
        Item fiole = new Fiole();
        survivor1.putItemInBackpack(carte);
        survivor1.putInHand(fiole); */




    }
}
