package zombicide.action;

import exception.IsWallException;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;
import zombicide.map.util.Location;

public class ActionOpenDoor extends ActionSurvivor{

protected Map map;

/**
 * Constructs a new ActionSurvivor object with the specified Survivor.
 *
 * @param s the Survivor associated with this action.
 */
public ActionOpenDoor(Survivor s) {
    super(s);
    this.map = null;
}

/**
 * Set a map to this Action
 * @param map the Map the survivor is on
 */
public void setMap(Map map){
    this.map = map;
}


/**
 * Open the neighbor door of the current Cell
 * @param callable a callable, here it's the Location of the door we want to open
 */
@Override
public void make(Callable callable) {
    Cell cellOfSurvivor = this.survivor.getCell();
    try{
        this.map.openDoorOfRoom(cellOfSurvivor, (Location)callable);
    }
    catch (IsWallException is){
        System.out.println("Its a wall around here.");
    }
}


/**
 * Gets the cost of the current ACtion
 * @return the cost of this action
 */
    @Override
    public int getCost() {
        return 0;
    }



}
