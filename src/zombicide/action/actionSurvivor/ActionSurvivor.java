package zombicide.action.actionSurvivor;
import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

import java.util.List;

/**
 * The abstract class ActionSurvivor represents an action that can be performed by a Survivor.
 * This class implements the Action interface.
 */
public interface ActionSurvivor extends Action {

    /**
     * This method will be useful in each action.
     * It will prevent if the survivor can do or not the action of the class wanted
     * @return true if the survivor had been able to do the action wanted
     */
    boolean canMakeAction();

    /**
     * Gets the cost of performing this action.
     * @return the cost of performing this action.
     */
     int getCost();

    /**
     * Retrieves the list of choices the survivors can make with this action
     * @return the list of choices
     */
    List<Callable> getChoices();
}


