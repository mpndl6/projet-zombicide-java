package zombicide.action.actionSurvivor;

import exception.IsWallException;
import zombicide.Game;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.map.Map;
import zombicide.item.*;
import zombicide.map.cell.Room;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This action permits to open a door
 */
public class OpenDoor implements ActionSurvivor {

protected Map map;
protected Callable callable;
protected Survivor survivor;
public static final int OPEN_COST = 1;

/**
 * Constructs a new ActionSurvivor object with the specified Survivor.
 * @param s the Survivor associated with this action.
 */
public OpenDoor(Survivor s, Map map) {
    this.survivor = s;
    this.map=map;
}

/**
 * Set a map to this Action
 * @param map the Map the survivor is on
 */
public void setMap(Map map){
    this.map = map;
}

/**
 * Gets the map of the current AttackOpenDoor
 * @return the map used for this action
 */
public Map getMap(){
    return this.map;
}

/**
 * Open the neighbor door of the current Cell
 * @return true if the action has been realised
 */
@Override
public boolean make(Callable callable) {
    if (!canMakeAction()) {
        System.out.println("the survivor doesn't have the correct item in hand.");
        return false;
    }
    Position survivorPos = this.survivor.getCell().getPosition();
    Game game  = this.survivor.getGame();
    Location l = (Location)callable;
    if(!(survivor.getCell() instanceof Room)) {
        switch (l) {
            case SOUTH:
                if (!((this.map.getCell(new Position(survivorPos.getX() + 1, survivorPos.getY()))) instanceof Room)) {
                    System.out.println("There's no such thing as a door in the south because there's no such thing as a room there.\n");
                    return false;
                }
                break;
            case NORTH:
                if (!((this.map.getCell(new Position(survivorPos.getX() - 1, survivorPos.getY()))) instanceof Room)) {
                    System.out.println("There's no such thing as a door in the north because there's no such thing as a room there.\n");
                    return false;
                }
                break;
            case EAST:
                if (!((this.map.getCell(new Position(survivorPos.getX(), survivorPos.getY() + 1))) instanceof Room)) {
                    System.out.println("There's no such thing as a door in the east because there's no such thing as a room there.\n");
                    return false;
                }
                break;
            case WEST:
                if (!((this.map.getCell(new Position(survivorPos.getX(), survivorPos.getY() - 1))) instanceof Room)) {
                    System.out.println("There's no such thing as a door in the west because there's no such thing as a room there.\n");
                    return false;
                }
                break;
        }
    }
    if (map.isOpenDoor(survivor.getCell(), l)){
        System.out.println("the door is already open.");
        return false;
    }
    try {
            CanOpenDoor itemOpenable = ((CanOpenDoor) this.survivor.getWhatINHand());
            itemOpenable.open( (Location)callable);
            game.spawnZombies(3);
            return true;
        }
        catch (IsWallException is) {
            System.out.println("It's a wall around here! Cant be open, broke or bombed with a weapon.\n");
            return false;
        }

}
/**
 * Gets the cost of the current ACtion
 * @return the cost of this action
 */
@Override
public int getCost() {
    return OPEN_COST;
}

/**
 * Retrieves the choices possible while opening a door
 * @return the list of different location
 * @see ActionSurvivor#getChoices()
 */
@Override
public List<Callable> getChoices() {
    List<Callable> newList = new ArrayList<>();
    Map mapOfSurvivor = this.survivor.getGame().getMap();
    newList.add(Location.NORTH);
    newList.add(Location.WEST);
    newList.add(Location.EAST);
    newList.add(Location.SOUTH);

    Iterator<Callable> iterator = newList.iterator();
    while (iterator.hasNext()) {
        Callable l = iterator.next();
        if (mapOfSurvivor.isWall(this.survivor.getCell(), (Location)l)) {
            iterator.remove();
        }
    }

    return newList;
}

/**
 * Checks if the survivor can perform the action
 * @return true if the survivor has an item in hand that can open a door, false otherwise.
 */
@Override
public boolean canMakeAction() {
    return (this.survivor.getWhatINHand() instanceof CanOpenDoor);
}

/**
 * Return the actor linked to this action
 * @return the actor linked to this action
 */
@Override
public Actor getActor() {
    return this.survivor;
}

/**
 * Gives a description of the action
 * @return the description of this action
 */
public String toString(){
    return "open";
}
}
