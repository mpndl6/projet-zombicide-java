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
        this.survivor.decreaseActionPoints(super.cost);
    }

    @Override
    public boolean canMakeAction() {
        return true;
    }

    /**
     * Performs the action of making noise by an survivor in the current room.
     */
    @Override
    public boolean make(Callable callable) throws Exception {
        if(this.canMakeAction()) {
            this.survivor.getCell().makenoise();
            this.survivor.decreaseActionPoints(this.getCost());
            return true;
        }
        return false;
    }
}
