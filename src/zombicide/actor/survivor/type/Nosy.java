package zombicide.actor.survivor.type;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

public class Nosy extends Survivor {

    private boolean firstSearchFree;
    /**
     * Contruct a survivor with their name in parameter.
     * At creation, a survivor has a Pistol in hand
     * 5 life points, 0 XP, 0 action points et nothing in backpack
     *
     * @param name the nickname of the survivor
     */
    public Nosy(String name) {
        super(name);
        this.firstSearchFree = true;
    }


    public boolean makeAction(Action action, Callable callable) throws Exception{
        boolean actionMade = false;
        if (firstSearchFree) {
            firstSearchFree = false;
            actionMade = action.make(callable);
        } else {
            if (this.getActionPoint() >= action.getCost()) {
                actionMade = action.make(callable);
                if (actionMade) {
                    decreaseActionPoints(action.getCost());
                }
            } else {
                System.out.println("Not enough action points to perform this action.");
            }
        }

        return actionMade;
    }
}