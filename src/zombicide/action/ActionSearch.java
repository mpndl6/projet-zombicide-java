package zombicide.action;

import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.Item;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;

public class ActionSearch extends ActionSurvivor {


    public ActionSearch(Survivor s) {
        super(s);
        this.cost = 1;
    }

    @Override
    public boolean canMakeAction() {
        if (!(super.survivor.getCell() instanceof Room)) {
            System.out.println("There's nothing in there, it's not a room.");
            return false;
        }
        return true;
    }


    @Override
    public boolean make(Callable callable) throws Exception {
        if (!canMakeAction())
            return false;
        Cell survivorCell = survivor.getCell();
        if (survivor.getAllInBackpack().size() < survivor.maxSizeOfBackPack()) {
            Item foundItem = Room.searchForItem(survivorCell);
            if (foundItem != null) {
                survivor.putItemInBackpack(foundItem);
                System.out.println(survivor.getNickName() + " found " + foundItem.toString() + " and put it in the backpack.");
                return true;
            } else {
                System.out.println("No item found in the room. Sorry ...");
                return false;
            }
        }
        else {
            Item discardedItem = survivor.chooseItemToDiscard();
            if (discardedItem != null) {
                survivor.putItemOnCell(discardedItem);
                System.out.println(survivor.getNickName() + " discarded " + discardedItem.toString() + " to make space in the backpack.");
                //On pourrait rappeler la méthode mais ça couterait un cout supplémentaire
                //return make(callable);

                Item foundItem = Room.searchForItem(survivorCell);
                if (foundItem != null) {
                    survivor.putItemInBackpack(foundItem);
                    return true;
                }
            }
            else {
                System.out.println(survivor.getNickName() + " couldn't find any item in the room.");
                return false;
            }
        }
        return false;
    }
}
