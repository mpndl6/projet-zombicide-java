package zombicide.action.actionSurvivor;

import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

import java.util.ArrayList;
import java.util.List;

/**
 * Class make noise, action that permits to raise the noise level of the cell of the survivor
 */
public class MakeNoise implements ActionSurvivor {

    protected Survivor survivor;
    protected static final int MAKE_NOISE_COST = 1;

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

    /**
     * Retrives the cost of the action makeNoise
     * @return the amount
     */
    @Override
    public int getCost() {
        return MAKE_NOISE_COST;
    }

    /**
     * Return null because there's no choices, but the current cell the survivor is in, to make noise
     * @return null
     */
    @Override
    public List<Callable> getChoices() {
        return new ArrayList<>();
    }

    /**
     * Retrives the actor linked to this action
     * @return the actor linked to this action
     */
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
            System.out.println("The noise level of the cell has just increase\n Noise Level of the cell :"+ this.survivor.getCell().getNoiseLevel()+" \n");
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the Action make noise.
     *
     * @return The string "make noise".
     */
    public String toString(){
        return "make noise";
    }
}
