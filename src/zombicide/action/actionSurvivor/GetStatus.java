package zombicide.action.actionSurvivor;

import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an action where a Survivor gets their current status.
 */
public class GetStatus implements ActionSurvivor{

    protected Survivor survivor;
    public static final int GET_STATUS_COST =0;


    /**
     * Constructs a new GetStatus action with the specified Survivor.
     *
     * @param s the Survivor associated with this action.
     */
    public GetStatus(Survivor s){
        this.survivor = s;
    }

    /**
     * Performs the action of getting the status of the associated Survivor.
     * Prints the status of the Survivor to the console.
     *
     * @param callable not used in this implementation.
     * @return always returns true.
     */
    @Override
    public boolean make(Callable callable) {
        System.out.println(survivor);
        return true;
    }

    /**
     * Gets the Actor associated with this action, which is the Survivor.
     *
     * @return the Survivor associated with this action.
     */
    @Override
    public Actor getActor() {
        return this.survivor;
    }

    /**
     * Checks if the action can be performed.
     * In this implementation, the action can always be performed.
     *
     * @return always returns true.
     */
    @Override
    public boolean canMakeAction() {
        return true;
    }

    /**
     * Gets the cost of performing this action.
     * In this implementation, the cost is 0.
     *
     * @return the cost of performing this action.
     */
    @Override
    public int getCost() {
        return GET_STATUS_COST;
    }

    /**
     * Gets the list of choices for this action.
     * In this implementation, there are no choices, so an empty list is returned.
     *
     * @return an empty list of choices.
     */
    @Override
    public List<Callable> getChoices() {
        return new ArrayList<>();
    }

    /**
     * Returns a string representation of this object, which is "get my status".
     *
     * @return the string "get my status".
     */
    public String toString(){
        return "get my status";
    }
}
