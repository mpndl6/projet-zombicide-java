package zombicide.action;

import exception.NoSuchItemException;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

public class MakeNoise extends ActionSurvivor{
    /**
     * Constructor for the makeNoise action.
     *
     * @param s The survivor performing the action
     */
    public MakeNoise(Survivor s) {
        super(s);
    }

    /**
     * Tells if the action can be made
     * @return true if the action can be madeK
     */
    @Override
    public boolean canMakeAction() {
        return true;
    }

    /**
     * Performs the action of making noise by an survivor in the current room.
     *
     * @param callable Any object in the game that is callable. Will be cast depending on the action.
     * @return true if the action is successfully made, false otherwise.
     * @throws Exception If an error occurs during the action.
     */
    @Override
    public boolean make(Callable callable) throws Exception {
        if(this.canMakeAction()) {
            this.survivor.getCell().makenoise();
            return true;
        }
        return false;
    }
}
