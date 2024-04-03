package zombicide.map;
import exception.IsWallException;
import grid.Grid;
import exception.FullBackpackException;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.survivor.type.Fighter;
import zombicide.actor.survivor.type.Healer;
import zombicide.actor.survivor.type.Lucky;
import zombicide.actor.survivor.type.Nosy;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.type.*;
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
        Survivor healer = new Healer("Jul");
        Survivor nosy = new Nosy("Youss");
        Survivor fighter= new Fighter("Annie");
        Survivor lucky = new Lucky("Gab");

        Position crossRoadPos = map.getCrossRoad();

        //add of players on principal street
        map.putActorONCell(healer,crossRoadPos);
        map.putActorONCell(nosy, crossRoadPos);
        map.putActorONCell(fighter, crossRoadPos);
        map.putActorONCell(lucky, crossRoadPos);

        try{
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
        }
        catch (FullBackpackException f){
            System.out.println("the backpack is full. Throw one item on cell.");
        }
        System.out.println("first display of the map:");
        Grid grid = new Grid(map, weightOfCells);
        grid.displayGrid();
        System.out.println(); //espace
        // pour l'instant les joueurs sont sur la map (a4 : 4 acteurs)

        //dans le deuxieme affichage déplacer les joueurs vers la case du nord mais il faut un obj pour ouvrir une porte je pense

        // En attendant la création des utilitaires (Ajout de la carte dans le backpack + de la fiole dans la main:

        //survivors deplacement upside
        try {
            System.out.println("Survivors go upside :");
            map.moveActor(healer,Location.NORTH);
            map.moveActor(nosy,Location.NORTH);
            map.moveActor(fighter,Location.NORTH);
            map.moveActor(lucky,Location.NORTH);
            grid.displayGrid();

            /**
            //test healer deplacement to the right
            map.openDoorOfRoom(healer.getCell(), Location.EAST); // open the door
            map.moveActor(healer, Location.EAST);
            System.out.println("healer moves to the right :");
            grid.displayGrid();

            //test fighter deplacement downside
            map.moveActor(fighter, Location.SOUTH);
            System.out.println("fighter moves downside :");
            grid.displayGrid();*/
        }
        catch (IsWallException e){
            System.out.println("It's wall around here.");
            System.out.println(healer.getCell().getPosition());
        }

        //construction zombie
        Zombie abomination = new Abomination();
        Zombie runner = new Runner();
        Zombie powerful = new Powerful();
        Zombie walker = new Walker();

        fighter.increaseXP();
       map.putActorONCell(abomination, map.getPositionOFWaster(Location.NORTH));
        map.putActorONCell(runner, map.getPositionOFWaster(Location.EAST));
        map.putActorONCell(powerful, map.getPositionOFWaster(Location.WEST));
        map.putActorONCell(walker, map.getPositionOFWaster(Location.SOUTH));
        System.out.println("zombies appear");
        grid.displayGrid();
        System.out.println("Survivors on map : \n");
        System.out.println(fighter+"\n");
        System.out.println(lucky+"\n");
        System.out.println(nosy+"\n");
        System.out.println(healer+"\n");
        System.out.println(abomination+"\n");
        System.out.println(powerful+"\n");
        System.out.println(walker+"\n");
        System.out.println(runner+"\n");



    }
}
