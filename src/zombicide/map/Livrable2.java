package zombicide.map;
import grid.Grid;
import zombicide.actor.survivors.Survivor;
import zombicide.actor.survivors.type.Fighter;
import zombicide.actor.survivors.type.Healer;
import zombicide.actor.survivors.type.Lucky;
import zombicide.actor.survivors.type.Nosy;
import zombicide.item.utility.Plan;
import zombicide.item.utility.Vial;
import zombicide.map.util.Position;

import java.util.*;


public class Livrable2 {
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        //Ville d'entraienement :
        int weightOfMap= 10;
        int heightOfMap=10;
        int weightOfCells=7;

        Map map = new Map(weightOfMap,heightOfMap);

        Survivor survivor1 = new Healer("Dr.Dre");
        Survivor survivor2 = new Nosy("snoop");
        Survivor survivor3= new Fighter("Meek");
        Survivor survivor4 = new Lucky("zz");

        Position crossRoad = map.getPrincipalIntersection();

        //ajout des joueurs sur la cellules
        map.putActorONCell(survivor1,crossRoad);
        map.putActorONCell(survivor2, crossRoad);
        map.putActorONCell(survivor3, crossRoad);
        map.putActorONCell(survivor4, crossRoad);

        //ajout des fioles en main
        survivor1.putInHand(new Vial());
        survivor2.putInHand(new Vial());
        survivor3.putInHand(new Vial());
        survivor4.putInHand(new Vial());

        //ajout des carte dans le sac
        survivor1.putItemInBackpack(new Plan());
        survivor2.putItemInBackpack(new Plan());
        survivor3.putItemInBackpack(new Plan());
        survivor4.putItemInBackpack(new Plan());

        // premier affichage
        Grid grid = new Grid(map, weightOfCells);
        grid.displayGrid();
        // pour l'instant les joueurs sont sur la map (a4 : 4 acteurs)

        //dans le deuxieme affichage déplacer les joueurs vers la case du nord mais il faut un obj pour ouvrir une porte je pense

        // En attendant la création des utilitaires (Ajout de la carte dans le backpack + de la fiole dans la main:




    }
}
