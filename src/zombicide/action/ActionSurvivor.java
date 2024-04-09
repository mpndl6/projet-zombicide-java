package zombicide.action;

import exception.NoSuchItemException;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.callable.Callable;

/**
 * The abstract class ActionSurvivor represents an action that can be performed by a Survivor.
 * This class implements the Action interface.
 */
public abstract class ActionSurvivor implements Action {
    protected int cost; //The cost of performing this action.

    protected Survivor survivor; //The Survivor associated with this action.

    /**
     * Constructs a new ActionSurvivor object with the specified Survivor.
     * @param s the Survivor associated with this action.
     */
    public ActionSurvivor(Survivor s) {
        this.cost = 1;
        this.survivor = s;
    }

    /**
     * This method will be useful in each action.
     * It will prevent if the survivor can do or not the action of the class wanted
     * @return true if the survivor had been able to do the action wanted
     */
    public abstract boolean canMakeAction();

    /**
     * Gets the cost of performing this action.
     * @return the cost of performing this action.
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Gets the Survivor associated with this action.
     * @return the Survivor associated with this action.
     */
    public Survivor getSurvivor() {
        return this.survivor;
    }

    /**
     * Abstract method to be implemented by subclasses to perform the action.
     */
    public abstract boolean make(Callable callable);
}


