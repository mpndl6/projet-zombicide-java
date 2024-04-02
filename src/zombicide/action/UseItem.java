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
     *
     * @return
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
        if(!this.canMakeAction())
            throw new NoSuchItemException("There's no item in their hand.");

        Item i = (Item) callable;
        i = super.survivor.getWhatINHand();
        i.addSurvivor(this.survivor);
        i.use();
        return true;
        }
    }

