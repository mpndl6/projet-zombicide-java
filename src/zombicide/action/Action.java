package zombicide.action;
import zombicide.actor.Actor;
import zombicide.callable.Callable;

/**
 * Interface Action represents all the actions doable by the actors
 */
public interface Action extends Callable {
    /**
     * Performs the action associated with this object.
     * This method should be implemented by concrete classes to define
     * specific behavior for the action.
     */
    boolean make(Callable callable);

    /**
     * Retrieves to actor linked to the action
     * @return the actor linked to the action
     */
    Actor getActor();
}



