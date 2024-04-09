package zombicide.action;

import exception.NoSuchItemException;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.Item;

public class UseItem extends ActionSurvivor {
    /**
     * Constructs a new ActionSurvivor object with the specified Survivor.
     *
     * @param s the Survivor associated with this action.
     */
    public UseItem(Survivor s) {
        super(s);
    }

    /**
     * Tells if the survivor can make the action of using an item.
     * They can, always. Unless they have no item in hand
     * @return true if the survivor can realise this action
     */
    @Override
    public boolean canMakeAction() {
        return super.survivor.getWhatINHand()!=null;
    }

    /*
    * Executes the action of using the item currently held by the survivor associated with this action

    */
    @Override
    public boolean make(Callable callable) throws Exception {
        if(!this.canMakeAction()) {
            System.out.println("There's no item in their hand.");
            return false;
        }
        Item i = super.survivor.getWhatINHand();
        //i.addSurvivor(this.survivor); <- déjà géré autrepart ça normalement
        i.use(callable);
        return true;
        }
    }

