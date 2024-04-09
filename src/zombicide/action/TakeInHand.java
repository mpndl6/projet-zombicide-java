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


/**
 * Performs the action of taking an item from the survivor's backpack and placing it in their hand.
 * If the survivor already has an item in hand, that item is placed back in the backpack.
 *
 * @param callable The item to take from the backpack and place in hand.
 * @return true if the action is performed successfully, false otherwise.
 * @throws FullBackpackException If the backpack is full after taking an item.
 * */
    @Override
    public boolean make(Callable callable) throws Exception {
        Item itemInHand = survivor.getWhatINHand();
        Item newItem = (Item) callable;

        if (newItem != null) {
            survivor.setInHand(newItem);
            survivor.removeItemFromBackpack(newItem);
        } else {
            return false;
        }

        if (itemInHand != null) {
            if (survivor.getAllInBackpack().size() >= Survivor.MAX_NB_ITEM) {
                throw new FullBackpackException("Backpack full");
            } else {
                survivor.putItemInBackpack(itemInHand);
            }
        }

        return true;
}}
