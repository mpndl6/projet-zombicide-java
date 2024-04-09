package zombicide.action;

import exception.NoSuchItemException;
import zombicide.actor.zombie.Zombie;
import zombicide.callable.Callable;

/**
 * The abstract class ActionZombie represents an action that can be performed by a Zombie.
 * This class implements the Action interface.
 */
public abstract class ActionZombie implements Action {
    protected int cost; //The cost of performing this action
    protected Zombie zombie; //The Zombie associated with this action.

    /**
     * Constructs a new ActionZombie object with the specified Zombie.
     * @param z the Zombie associated with this action.
     */
    public ActionZombie(Zombie z) {
        this.cost = 1;
        this.zombie = z;
    }

    /**
     * Gets the cost of performing this action.
     * @return the cost of performing this action.
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Gets the Zombie associated with this action.
     * @return the Zombie associated with this action.
     */
    public Zombie getZombie() {
        return this.zombie;
    }

    /**
     * Abstract method to be implemented by subclasses to perform the action.
     */
    public abstract boolean make(Callable callable);
}


