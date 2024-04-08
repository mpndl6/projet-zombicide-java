package zombicide.action;

import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.map.cell.*;
import zombicide.map.util.*;

/**
 *
 */
public class MoveAside extends ActionSurvivor {

    /**
     * Constructs a new ActionSurvivor object with the specified Survivor.
     *
     * @param s the Survivor associated with this action.
     */
    public MoveAside(Survivor s) {
        super(s);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean canMakeAction() {
        return true;
    }

    /**
     *
     * @param callable
     * @return
     * @throws Exception
     */
    @Override
    public boolean make(Callable callable) throws Exception {
        Cell cell = survivor.getCell();
        Position p = cell.getPosition();
        int xCell = p.getX();
        int yCell = p.getY();
        if (!canMakeAction())
            return false;
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
