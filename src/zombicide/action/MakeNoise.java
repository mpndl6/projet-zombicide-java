package zombicide.action;

import zombicide.actor.survivor.Survivor;

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
     * Performs the action of making noise by an survivor in the current room.
     */
    @Override
    public void make() {
        if(this.survivor.getActionPoint()>0) {
            this.survivor.getCell().makenoise();
            this.survivor.decreaseActionPoints();
        }
    }
}
