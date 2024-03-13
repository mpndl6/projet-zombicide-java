package zombicide.map;
import grid.Grid;
import zombicide.actor.survivors.Survivor;
import zombicide.actor.survivors.type.Fighter;
import zombicide.actor.survivors.type.Healer;
import zombicide.actor.survivors.type.Lucky;
import zombicide.actor.survivors.type.Nosy;
import zombicide.item.utility.Plan;
import zombicide.item.utility.Vial;
import zombicide.map.cell.room.Continental;
import zombicide.map.cell.room.DrugStore;
import zombicide.map.util.Position;
import zombicide.map.cell.*;

import java.util.*;


public class Livrable2 {
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        //Ville d'entraienement :
        int weightOfMap= 5;
        int heightOfMap=5;
        int weightOfCells=7;

        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();

        liststreets.add(new StreetWW());
        listrooms.add(new Continental());
        listrooms.add(new DrugStore());


        Map map = new Map(weightOfMap,heightOfMap,listrooms,liststreets);

        Survivor survivor1 = new Healer("Dr.Dre");
        Survivor survivor2 = new Nosy("snoop");
        Survivor survivor3= new Fighter("Meek");
        Survivor survivor4 = new Lucky("zz");

        Position crossRoadPos = map.getPrincipalIntersection();
        Cell crossRoad = map.getCell(crossRoadPos);
        //ajout des joueurs sur la cellules
        map.putActorONCell(survivor1,crossRoadPos);
        map.putActorONCell(survivor2, crossRoadPos);
        map.putActorONCell(survivor3, crossRoadPos);
        map.putActorONCell(survivor4, crossRoadPos);


        //ajout des fioles en main
        survivor1.putInHand(new Vial());
        survivor2.putInHand(new Vial());
        survivor3.putInHand(new Vial());
        survivor4.putInHand(new Vial());

        //ajout des carte dans le sac
        survivor1.putItemInBackpack(new Plan(map));
        survivor2.putItemInBackpack(new Plan(map));
        survivor3.putItemInBackpack(new Plan(map));
        survivor4.putItemInBackpack(new Plan(map));

        // premier affichage
        Grid grid = new Grid(map, weightOfCells);
        grid.displayGrid();
        // pour l'instant les joueurs sont sur la map (a4 : 4 acteurs)

        //dans le deuxieme affichage déplacer les joueurs vers la case du nord mais il faut un obj pour ouvrir une porte je pense

        // En attendant la création des utilitaires (Ajout de la carte dans le backpack + de la fiole dans la main:

      List<Survivor> listSurvivor = new ArrayList<Survivor>();
        listSurvivor.add(survivor1);
        listSurvivor.add(survivor2);
        listSurvivor.add(survivor3);
        listSurvivor.add(survivor4);

        for(Survivor s : listSurvivor){
            Cell currentCell = s.getCell();
            Position positionCellAbove = new Position(currentCell.getPosition().getX()-1, currentCell.getPosition().getY());
            Cell cellAbove = map.getCells()[currentCell.getPosition().getX()-1][currentCell.getPosition().getY()];
            Position pCell = cellAbove.getPosition();
           map.putActorONCell(s,pCell);

        }
        System.out.println();
        grid.displayGrid();




    }
}
