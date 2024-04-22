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

/**
 * This method permits to an object Actor to move aside.
 */
public class MoveAside implements ActionSurvivor, ActionZombie {

    protected Actor actor;

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

        Location l = (Location)callable;
        if (!canMakeAction()  ||map.isWall(cell,l) || !map.isOpenDoor(cell,l)) {
            return false;
        }

        switch (l) {
            case NORTH:
                map.putActorONCell(this.actor, new Position(xCell - 1, yCell));
                System.out.println("up");
                return true;
            case SOUTH:
                map.putActorONCell(this.actor, new Position(xCell + 1, yCell));
                System.out.println("down");
                return true;
            case EAST:
                map.putActorONCell(this.actor, new Position(xCell, yCell + 1));
                System.out.println("east");
                return true;
            case WEST:
                map.putActorONCell(this.actor, new Position(xCell, yCell - 1));
                System.out.println("west");
                return true;

            default:
                System.out.println("le zombie ne peut pas bouger");
                return false;

        }
    }

    /**
     * Retrieves the cost of the action MoveAside
     * @return the cost of this action
     */
    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public Actor getActor() {
        return this.actor;
    }
}
