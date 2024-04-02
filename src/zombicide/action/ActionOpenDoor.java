package zombicide.action;

import exception.IsWallException;
import exception.NoSuchItemException;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.item.*;
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
 * @return true if the action has been realised
 */
@Override
public boolean make(Callable callable) throws Exception {
    if (!canMakeAction())
        throw new NoSuchItemException(this.survivor.getNickName()+" doesn't have the correct item in hand");

        Cell cellOfSurvivor = this.survivor.getCell();
        try {
            this.map.openDoorOfRoom(cellOfSurvivor, (Location) callable);
            this.survivor.decreaseActionPoints(super.getCost());
            return true;
        }
        catch (IsWallException is) {
            System.out.println("Its a wall around here.");
            return false;
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

    @Override
    public boolean canMakeAction() {
        return (super.survivor.getWhatINHand() instanceof CanOpenDoor) & super.survivor.getActionPoint()>0;
    }


}
