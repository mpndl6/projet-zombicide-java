package zombicide.action;

import exception.FullBackpackException;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.Item;

public class TakeInHand extends ActionSurvivor {

    /**
     * Constructs a new LookAround object with the specified Survivor.
     * @param s the Survivor associated with this action.
     */
    public TakeInHand(Survivor s) {
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
    public boolean make(Callable callable) throws Exception {
        if(survivor.getAllInBackpack().size() >= Survivor.MAX_NB_ITEM)
            throw new FullBackpackException("There's to many item in the backPack");
        if(survivor.hasItemOnHand())
            survivor.putItemInBackpack(survivor.getWhatINHand());
        survivor.setInHand((Item)callable);
        Item i = survivor.getWhatINHand();
        i.addSurvivor(survivor);
        return true;
    }



}
