package zombicide.action.actionSurvivor;

import zombicide.action.actionSurvivor.ActionSurvivor;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

public class MakeNoise implements ActionSurvivor {

    protected Survivor survivor;
    protected static final int MAKE_NOISE_COST = 0;

    /**
     * Constructor for the makeNoise action.
     * @param s The survivor performing the action
     */
    public MakeNoise(Survivor s) {
        this.survivor = s;
    }

    /**
     * Tells if the action can be made
     * @return true if the action can be madeK
     */
    @Override
    public boolean canMakeAction() {
        return true;
    }

    @Override
    public int getCost() {
        return MAKE_NOISE_COST;
    }

    @Override
    public Actor getActor() {
        return this.survivor;
    }

    /**
     * Performs the action of making noise by an survivor in the current room.
     * @param callable Any object in the game that is callable. Will be cast depending on the action.
     * @return true if the action is successfully made, false otherwise.
     * @throws Exception If an error occurs during the action.
     */
    @Override
    public boolean make(Callable callable){
        if(this.canMakeAction()) {
            this.survivor.getCell().makeNoise();
            return true;
        }
        return false;
    }
}
