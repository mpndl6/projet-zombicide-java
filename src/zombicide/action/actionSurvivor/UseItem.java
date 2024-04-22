package zombicide.action.actionSurvivor;

import zombicide.action.actionSurvivor.ActionSurvivor;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.Item;

/**
 * Permits to a survivor to use an Item
 */
public class UseItem implements ActionSurvivor {

    protected static final int USE_ITEM_COST = 1;
    protected Survivor survivor;

    /**
     * Constructs a new ActionSurvivor object with the specified Survivor.
     * @param s the Survivor associated with this action.
     */
    public UseItem(Survivor s) {
        this.survivor = s;
    }

    /**
     * Tells if the survivor can make the action of using an item.
     * They can, always. Unless they have no item in hand
     * @return true if the survivor can realise this action
     */
    @Override
    public boolean canMakeAction() {
        return survivor.getWhatINHand()!=null;
    }

    @Override
    public int getCost() {
        return USE_ITEM_COST;
    }

    /**
     * Retrieves the survivor linked to this action
     * @return the survivor linked to this action
     */
    @Override
    public Actor getActor() {
        return this.survivor;
    }

    /**
     * Method that permit to do the action of use any item
     * @param callable a callable, here it's an instance of Item
     * @return true if the action has been realise succesfully
     */
    @Override
    public boolean make(Callable callable){
        if(!this.canMakeAction()) {
            System.out.println("There's no item in their hand.");
            return false;
        }
        Item i = survivor.getWhatINHand();
        //i.addSurvivor(this.survivor); <- déjà géré autrepart ça normalement
        try {
            i.use(callable);
        }
        catch (Exception e){
            e.getMessage();
        }
        return true;
        }
    }

