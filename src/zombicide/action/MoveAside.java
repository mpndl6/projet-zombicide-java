package zombicide.action;

import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.map.cell.*;
import zombicide.map.util.*;

/**
 * This method permits to the survivor to move aside.
 */
public class MoveAside extends ActionSurvivor {

    /**
     * Constructs a new ActionSurvivor object with the specified Survivor.
     * @param s the Survivor associated with this action.
     */
    public MoveAside(Survivor s) {
        super(s);
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
     * This methode moves the survivor to a specific cell.
     * Survivors have cell and those cell can have different positions.
     * @param callable a callable, here it's an instance of Location
     * @return true if the survivor has moved eventually
     */
    @Override
    public boolean make(Callable callable){
        Cell cell = survivor.getCell();
        Position p = cell.getPosition();
        int xCell = p.getX();
        int yCell = p.getY();
        if (!canMakeAction()) {
            System.out.println("Survivor is trying to go outside of the Map!");
            return false;
        }
        Location l = (Location)callable;
        switch (l){
            case NORTH:
                cell.setPosition(new Position(xCell-1, yCell));
                return true;
            case SOUTH:
                cell.setPosition(new Position(xCell+1, yCell));
                return true;
            case EAST:
                cell.setPosition(new Position(xCell, yCell+1));
                return true;
            case WEST:
                cell.setPosition(new Position(xCell, yCell-1));
                return true;
            default:
                return false;

        }
    }
}
