package zombicide.action.actionSurvivor;

import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.survivor.type.Healer;
import zombicide.callable.Callable;

import java.util.ArrayList;
import java.util.List;

public class Heal implements ActionSurvivor{

    protected Survivor survivor;
    public static final int HEAL_ACTION_COST = 1;

    /**
     * Constructs a new LookAround object with the specified Survivor.
     * @param s the Survivor associated with this action.
     */
    public Heal(Survivor s) {
        this.survivor = s;
    }

    /**
     * Retrieves the list of choices the survivors can make with this action
     * @return the list of choices
     * @see ActionSurvivor#getChoices()
     */
    public List<Callable> getChoices() {
        List<Callable> survivors = new ArrayList<>();
        if (this.survivor.getCell().howManySurvivors() > 0) {
            for (Callable c : this.survivor.getCell().getActors()) {
                if (c instanceof Survivor)
                    survivors.add(c);
            }
            return survivors;
        }
        survivors.add(this.survivor);
        return survivors;
    }

    /**
     *
     * Checks if the Survivor can perform the action of looking around.
     * @return true if the Survivor can perform the action, false otherwise.
     */
    public boolean canMakeAction(){
        if (this.survivor instanceof Healer)
            return false;
        return true;
    }

    /**
     * the cost of this action
     * @return the amount of the cost of this action
     */
    @Override
    public int getCost() {
        return HEAL_ACTION_COST;
    }

    /***
     * Return the actor linked to this action
     * @return
     */
    @Override
    public Actor getActor() {
        return this.survivor;
    }

    /**
     * Performs the action of looking around.
     * This method calls the description method of the cell the Survivor is currently in.
     * It overrides the methode make of the superclass
     * @param callable A callable object
     * @return true if the action was successfully performed, false otherwise
     */
    @Override
    public boolean make(Callable callable){

        if(!canMakeAction()){
            System.out.println("not a healer.\nstop");
            return false;
        }
       Healer healer = ((Healer)this.survivor);
        healer.heal((Survivor)callable);
        return true;
    }

    public String toString(){
        return "heal";
    }
}
