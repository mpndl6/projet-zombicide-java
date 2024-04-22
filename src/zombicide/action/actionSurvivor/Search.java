package zombicide.action.actionSurvivor;

import exception.FullBackpackException;
import zombicide.action.actionSurvivor.ActionSurvivor;
import zombicide.actor.Actor;
import zombicide.actor.PNJ;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.Item;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;

/**
 * Class of Search
 */
public class Search implements ActionSurvivor {
protected static final int SEARCH_COST = 1;
protected Survivor survivor;

    /**
     * Constructs an object Search with a survivor in parameter
     * This action is allowed to survivors only
     * @param s the survivor linked to this action
     */
    public Search(Survivor s) {
        this.survivor = s;
    }

    /**
     * Tells if the survivor can make this action
     * They can if they are in a room
     * @return true if they can make this action
     */
    @Override
    public boolean canMakeAction() {
        if (!(survivor.getCell() instanceof Room)) {
            System.out.println("There's nothing in there, it's not a room.\n Search can't be proceed");
            return false;
        }
        return true;
    }

    /**
     * Retrives the cost of this action
     * @return the cost of this action
     */
    @Override
    public int getCost() {
        return 0;
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
     * This action permits to search an item in the current room
     * @param callable not needed in this method
     * @return true if the survivor has found something
     */
    @Override
    public boolean make(Callable callable) {
        if (!canMakeAction())
            return false;

        Cell survivorCell = survivor.getCell();
        if (survivor.getAllInBackpack().size() < Survivor.MAX_NB_ITEM) {
            Item foundItem = Room.searchForItem(survivorCell);
            if (foundItem != null) {
                try {
                    survivor.putItemInBackpack(foundItem);
                    System.out.println(survivor.getNickName() + " found " + foundItem + " and put it in the backpack.\nEnd of search");
                    return true;
                }
                catch (FullBackpackException f) {
                    System.out.println("Backpack is full. End of search.");
                    return false;
                }
            }
            else {
                System.out.println("No item found in the room. Sorry ...\n End of search.");
                return false;
            }
        }
        else {
            boolean survivorWantToDropOffSomeItem = PNJ.generateRandomResponse(); // survivor chooses randomly if they want or not to drop off something to swap an item for another
            if (!survivorWantToDropOffSomeItem) {
                System.out.println("BackPack's full. and "+survivor.getNickName() + " dosent want to give something up. End of search.");
                return false;
            }
            //else
            Item discardedItem = Survivor.chooseItemToDiscard(survivor);
            if (discardedItem != null) {
                survivor.putItemOnCell(discardedItem);
                System.out.println(survivor.getNickName() + " discarded " + discardedItem+ " to make space in the backpack.");
                Item foundItem = Room.searchForItem(survivorCell);
                if (foundItem != null) {
                    try {
                        survivor.putItemInBackpack(foundItem);
                        return true;
                    }
                    catch (FullBackpackException f){
                        System.out.println("Backpack is full.");
                        return false;
                    }
                }
            }
            else {
                System.out.println(survivor.getNickName() + " couldn't find any item in the room.\n End of search");
                return false;
            }
        }
        return false;
    }
}
