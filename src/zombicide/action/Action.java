package zombicide.action;

import exception.NoSuchItemException;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

/**
 * Interface Action represents all the actions doable by the actors
 */
public interface Action {
    /**
     * Performs the action associated with this object.
     * This method should be implemented by concrete classes to define
     * specific behavior for the action.
     */
    public boolean make(Callable callable);

    /**
     * Gets the cost of the action that will be required
     * This method should be implemented by concrete classes
     */
    public int getCost();

    /**
    * Tells if the actionc can be realised
    * @return true if the action can be realised
     */
    public boolean canMakeAction();
}



