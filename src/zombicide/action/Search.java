package zombicide.action;

import exception.FullBackpackException;
import exception.NoSuchItemException;
import zombicide.actor.PNJ;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.Item;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;

public class Search extends ActionSurvivor {


    public Search(Survivor s) {
        super(s);
        this.cost = 1;
    }

    @Override
    public boolean canMakeAction() {
        if (!(super.survivor.getCell() instanceof Room)) {
            System.out.println("There's nothing in there, it's not a room.\n Search can't be proceed");
            return false;
        }
        return true;
    }


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
