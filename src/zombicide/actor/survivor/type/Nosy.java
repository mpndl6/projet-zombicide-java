package zombicide.actor.survivor.type;

import zombicide.action.Action;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

/**
 * Class of the nosy
 */
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


    /**
     * Permits to the survivor to make an Action.
     * @param action The action wanted by the survivor
     * @param callable any object in this game that is callable. Will be cast depending on the action.
     * @return true if the action has been done successfully
     */
    @Override
    public boolean makeAction(Action action, Callable callable){
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