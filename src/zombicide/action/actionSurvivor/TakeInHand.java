package zombicide.action.actionSurvivor;

import exception.FullBackpackException;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.Item;

/**
 * Class Take In Hand
 */
public class TakeInHand implements ActionSurvivor {
    protected static final int TAKE_IN_HAND_COST = 1;
    protected Survivor survivor;

    /**
     * Constructs a new LookAround object with the specified Survivor.
     * @param s the Survivor associated with this action.
     */
    public TakeInHand(Survivor s) {
        this.survivor = s;
    }

    /**
     *
     * Checks if the Survivor can perform the action of Taking in Hand\n
     * The only way they can't is if they have at the time a item on hand and the backpack is full
     * @return true if the Survivor can perform the action, false otherwise.
     */
    @Override
    public boolean canMakeAction(){
        if (survivor.getAllInBackpack().size() >= Survivor.MAX_NB_ITEM & survivor.getWhatINHand()!=null)
            return false;
        return true;
    }

    /**
     * Retrieves the cost of this action
     * @return the cost of the Action TakeInHand
     */
    @Override
    public int getCost() {
        return TAKE_IN_HAND_COST;
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
 * Performs the action of taking an item from the survivor's backpack and placing it in their hand.
 * If the survivor already has an item in hand, that item is placed back in the backpack.
 *
 * @param callable The item to take from the backpack and place in hand.
 * @return true if the action is performed successfully, false otherwise.
 * @throws FullBackpackException If the backpack is full after taking an item.
 * */
    @Override
    public boolean make(Callable callable){
        Item itemInHand = survivor.getWhatINHand();
        Item newItem = (Item) callable;
        if (!canMakeAction())
            return false;

        if (itemInHand != null) {
            try {
                survivor.putItemInBackpack(itemInHand);
                System.out.println(survivor.getWhatINHand()+" go in backpack.");
            } catch (FullBackpackException f) {
                System.out.println("Backpack full.");
            }
        }
        survivor.setInHand(newItem);
        newItem.addSurvivor(survivor);
// On géra dans game le fait qu'il veuille potentiellement jeter quelque chose sur la cell
        return true;
}
}
