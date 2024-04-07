package zombicide.action;

import exception.FullBackpackException;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.Item;

public class ActionTakeInHand extends ActionSurvivor {

    /**
     * Constructs a new LookAround object with the specified Survivor.
     * @param s the Survivor associated with this action.
     */
    public ActionTakeInHand(Survivor s) {
        super(s);
    }

    /**
     *
     * Checks if the Survivor can perform the action of looking around.
     * @return true if the Survivor can perform the action, false otherwise.
     */
    public boolean canMakeAction(){
        return true;
    }


    @Override
    public boolean make(Callable callable) throws FullBackpackException {
        if(survivor.hasItemOnHand())
            survivor.putItemInBackpack(survivor.getWhatINHand());
        survivor.setInHand((Item)callable);
        Item i = survivor.getWhatINHand();
        i.addSurvivor(survivor);
        return true;
    }



}
