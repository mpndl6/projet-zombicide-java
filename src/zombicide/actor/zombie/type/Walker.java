package zombicide.actor.zombie.type;

import zombicide.action.Action;
import zombicide.actor.zombie.Zombie;
import zombicide.callable.Callable;

/**
 * Represents a type of zombie known as a Walker.
 * Walkers are a type of zombie in the game Zombicide.
 * They are characterized by their slow movement speed and their ability to inflict moderate damage.
 */
public class Walker extends Zombie{
    public static final int WALKER_DAMAGES=1;
    public static final String WALKER_NN="Walker";

    /**
     * Constructs a new Walker zombie with default attributes.
     * The Walker zombie has the name "Walker", inflicts a default damage of 1,
     * and has lifePoint of 1.
     */
    public Walker(){
        super(WALKER_NN,WALKER_DAMAGES,1);
    }

    /**
     * Performs a sequence of actions for the Walker zombie.
     * This method executes the given action twice.
     *
     * @param action   the action to be performed by the Walker zombie.
     * @param callable the callable object used for the action.
     * @return true if at least one of the actions was successful, false otherwise.
     */
    public boolean makeAction(Action action, Callable callable){
       boolean firstAction =  action.make(callable);
       boolean secondACtion =  action.make(callable);
       return firstAction || secondACtion;
    }
}
