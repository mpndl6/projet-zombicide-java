package zombicide.action.actionSurvivor;

import zombicide.action.Action;
import zombicide.action.actionSurvivor.ActionSurvivor;
import zombicide.action.actionZombie.ActionZombie;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.map.Map;
import zombicide.map.cell.*;
import zombicide.map.util.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This method permits to an object Actor to move aside.
 */
public class MoveAside implements ActionSurvivor, ActionZombie {

    protected Actor actor;
    public static final int MOVE_COST =1;

    /**
     * Constructs a new ActionSurvivor object with the specified Survivor.
     * @param a the Survivor associated with this action.
     */
    public MoveAside(Actor a) {
        this.actor = a;
    }

    /**
     * This methode tells if the survivor can do this action.
     * It always returns true basically
     * @return true, always
     */
    @Override
    public boolean canMakeAction() {
        return true;
    }

    /**
     * This methode moves the actor to a specific cell.
     * @param callable a callable, here it's an instance of Location
     * @return true if the actor has moved eventually
     */
    @Override
    public boolean make(Callable callable){
        Cell cell = actor.getCell();
        Position p = cell.getPosition();
        int xCell = p.getX();
        int yCell = p.getY();
        Map map = this.actor.getGame().getMap();
        if (!(callable instanceof Location))
            return false;

       else if (!canMakeAction()) {
            return false;
        }
        Location l = (Location)callable;
         if (map.isWall(cell,l) || map.isOpenDoor(cell,l)) {
            System.out.println(this.actor.getNickName() + " tried to reach a wall or a door.\n Action move has not been succesful.\n");
            return false;
        }
        System.out.println(this.actor.getNickName()+" is on cell "+ this.actor.getCell().getPosition());

        switch (l) {
            case NORTH:
                map.putActorONCell(this.actor, new Position(xCell - 1, yCell));
                System.out.println(actor.getNickName()+" moved upside.");
                System.out.println(actor.getNickName()+ " is on cell "+actor.getCell().getPosition());
                return true;
            case SOUTH:
                map.putActorONCell(this.actor, new Position(xCell + 1, yCell));
                System.out.println(actor.getNickName()+" moved downside.");
                System.out.println(actor.getNickName()+ " is on cell "+actor.getCell().getPosition());
                return true;
            case EAST:
                map.putActorONCell(this.actor, new Position(xCell, yCell + 1));
                System.out.println(actor.getNickName()+" moved to the right.");
                System.out.println(actor.getNickName()+ " is on cell "+actor.getCell().getPosition());
                return true;
            case WEST:
                map.putActorONCell(this.actor, new Position(xCell, yCell - 1));
                System.out.println(actor.getNickName()+" moved to the left.");
                System.out.println(actor.getNickName()+ " is on cell "+actor.getCell().getPosition());
                return true;

            default:
                System.out.println("cannot move");
                return false;

        }
    }

    /**
     * Retrieves the cost of the action MoveAside
     * @return the cost of this action
     */
    @Override
    public int getCost() {
        return MOVE_COST;
    }

    /**
     * Returns the different location possible while moving aside
     * @return the list of the differret locations
     * @see ActionSurvivor#getChoices()
     */
    @Override
    public List<Callable> getChoices() {
        List<Callable> newList = new ArrayList<>();
        Map mapOfSurvivor = this.actor.getGame().getMap();
        newList.add(Location.NORTH);
        newList.add(Location.WEST);
        newList.add(Location.EAST);
        newList.add(Location.SOUTH);
        for(Callable l : newList){
            if (mapOfSurvivor.isWall(this.actor.getCell(), (Location)l))
                newList.remove(l);
        }
        return newList;
    }

    /**
     * Retrives the actor linked to this action
     * @return the actor linked to this action
     */
    @Override
    public Actor getActor() {
        return this.actor;
    }

    /**
     * Gives a description of this action
     * @return the description of this action
     */
    public String toString(){
        return "move";
    }
}
