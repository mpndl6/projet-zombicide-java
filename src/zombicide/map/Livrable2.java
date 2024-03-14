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
        Survivor healer = new Healer("Dr.Dre");
        Survivor nosy = new Nosy("snoop");
        Survivor fighter= new Fighter("Meek");
        Survivor lucky = new Lucky("zz");

        Position crossRoadPos = map.getPrincipalIntersection();

        //add of players on principal street
        map.putActorONCell(healer,crossRoadPos);
        map.putActorONCell(nosy, crossRoadPos);
        map.putActorONCell(fighter, crossRoadPos);
        map.putActorONCell(lucky, crossRoadPos);

        //add of vials in hand
        healer.putInHand(new Vial());
        nosy.putInHand(new Vial());
        fighter.putInHand(new Vial());
        lucky.putInHand(new Vial());

        //add of the plan on backpack
        healer.putItemInBackpack(new Plan(map));
        nosy.putItemInBackpack(new Plan(map));
        fighter.putItemInBackpack(new Plan(map));
        lucky.putItemInBackpack(new Plan(map));

        System.out.println("first display of the map:");
        Grid grid = new Grid(map, weightOfCells);
        grid.displayGrid();
        System.out.println(); //espace
        // pour l'instant les joueurs sont sur la map (a4 : 4 acteurs)

        //dans le deuxieme affichage déplacer les joueurs vers la case du nord mais il faut un obj pour ouvrir une porte je pense

        // En attendant la création des utilitaires (Ajout de la carte dans le backpack + de la fiole dans la main:

        //survivors deplacement upside
       map.moveActor(healer,Location.NORTH);
        map.moveActor(nosy,Location.NORTH);
        map.moveActor(fighter,Location.NORTH);
        map.moveActor(lucky,Location.NORTH);
        grid.displayGrid();

        //test healer deplacement to the right
        map.openDoorOfRoom(healer.getCell(), Location.EAST); // open the door
        map.moveActor(healer, Location.EAST);

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
        System.out.println(healer);
    }
}
