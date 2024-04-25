package zombicide.action.actionSurvivor;

import exception.FullBackpackException;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.Item;

import java.util.ArrayList;
import java.util.List;

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
        if (survivor.getAllInBackpack().size() >= Survivor.MAX_NB_ITEM & survivor.getWhatINHand()!=null) {
            System.out.println("No more room for another object to be taken.");
            return false;
        }
        if(this.survivor.getCell().getItems().size()==0 || this.survivor.getAllInBackpack().size()==0) {
            System.out.println("There is nothing in the cell and nothing in the backpack, sorry.");
            return false;
        }
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
     * Gives all the item present in t
     * @return
     */
    @Override
    public List<Callable> getChoices() {
        List<Callable> newList = new ArrayList<>();
        for(Item i : this.survivor.getAllInBackpack())
            newList.add(i);
        for(Item i : this.survivor.getCell().getItems())
            newList.add(i);
        return newList;
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
 * */
    @Override
    public boolean make(Callable callable){
        Item itemInHand = survivor.getWhatINHand();

        if (!canMakeAction() || !(callable instanceof Item))
            return false;
        Item newItem = (Item) callable;
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

    public String toString(){
        return "take in hand";
    }
}
