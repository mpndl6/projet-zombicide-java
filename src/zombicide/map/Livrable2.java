package zombicide.map;
import grid.Grid;
import zombicide.actor.survivors.Survivor;
import zombicide.actor.survivors.type.Fighter;
import zombicide.actor.survivors.type.Healer;
import zombicide.actor.survivors.type.Lucky;
import zombicide.actor.survivors.type.Nosy;
import zombicide.actor.zombies.Zombie;
import zombicide.actor.zombies.type.Abomination;
import zombicide.actor.zombies.type.Powerful;
import zombicide.actor.zombies.type.Runner;
import zombicide.actor.zombies.type.Walker;
import zombicide.item.utility.Plan;
import zombicide.item.utility.Vial;
import zombicide.map.cell.room.Continental;
import zombicide.map.util.Location;
import zombicide.map.util.Position;
import zombicide.map.cell.*;

import java.util.*;

/**
 * the second deliverable of the project.
 * Based on subclass Training map where there's method used for this deliverable but won't be used for the final
 * conception.
 * It's for the purpose of expansion and avoid to change the code when deliverable it's over.
 */
public class Livrable2 {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        //Training map :
        int weightOfCells=10;

        //Add of special room and special street
        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();

        liststreets.add(new StreetWW());
        listrooms.add(new Continental());
       // listrooms.add(new DrugStore());


        TrainingMap2 map = new TrainingMap2(listrooms,liststreets);

        //new survivors constrcuted
        Survivor survivor1 = new Healer("Dr.Dre");
        Survivor survivor2 = new Nosy("snoop");
        Survivor survivor3= new Fighter("Meek");
        Survivor survivor4 = new Lucky("zz");

        Position crossRoadPos = map.getPrincipalIntersection();

        //add of players on principal street
        map.putActorONCell(survivor1,crossRoadPos);
        map.putActorONCell(survivor2, crossRoadPos);
        map.putActorONCell(survivor3, crossRoadPos);
        map.putActorONCell(survivor4, crossRoadPos);

        //add of vials in hand
        survivor1.putInHand(new Vial());
        survivor2.putInHand(new Vial());
        survivor3.putInHand(new Vial());
        survivor4.putInHand(new Vial());

        //add of the plan on backpack
        survivor1.putItemInBackpack(new Plan(map));
        survivor2.putItemInBackpack(new Plan(map));
        survivor3.putItemInBackpack(new Plan(map));
        survivor4.putItemInBackpack(new Plan(map));

        System.out.println("first display of the map:");
        Grid grid = new Grid(map, weightOfCells);
        grid.displayGrid();
        System.out.println(); //espace
        // pour l'instant les joueurs sont sur la map (a4 : 4 acteurs)

        //dans le deuxieme affichage déplacer les joueurs vers la case du nord mais il faut un obj pour ouvrir une porte je pense

        // En attendant la création des utilitaires (Ajout de la carte dans le backpack + de la fiole dans la main:

        //survivors deplacement upside
       map.moveActor(survivor1,Location.NORTH);
        map.moveActor(survivor2,Location.NORTH);
        map.moveActor(survivor3,Location.NORTH);
        map.moveActor(survivor4,Location.NORTH);
        grid.displayGrid();

        //test survivor1 deplacement to the right
        map.openDoorOfRoom(survivor1.getCell(), Location.EAST); // open the door
        map.moveActor(survivor1, Location.EAST);

        //construction zombie
        Zombie abomination = new Abomination();
        Zombie runner = new Runner();
        Zombie powerful = new Powerful();
        Zombie walker = new Walker();

        map.putActorONCell(abomination, map.getPositionOFWaster(Location.NORTH));
        map.putActorONCell(runner, map.getPositionOFWaster(Location.EAST));
        map.putActorONCell(powerful, map.getPositionOFWaster(Location.WEST));
        map.putActorONCell(walker, map.getPositionOFWaster(Location.SOUTH));

        grid.displayGrid();
        System.out.println(survivor1);
    }
}
