package zombicide.action;

import exception.NoSuchItemException;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.Item;
import zombicide.map.cell.Room;

import java.util.List;

/**
 * Represents the action of searching for items in a room.
 */
public class Search extends ActionSurvivor {
    /**
     * Constructor for the search action.
     *
     * @param s The survivor performing the search.
     */
    public Search(Survivor s) {
        super(s);
        this.cost = 1;
    }

    @Override
    public boolean canMakeAction() {
        if(!(super.survivor.getCell() instanceof Room)) {
            System.out.println("There's nothing in there, it's not a room.");
            return false;
        }
         return true;
    }

    /**
     * Performs the action of searching for items in the current room.
     */
    @Override
    public boolean make(Callable callable) throws Exception {
        if (!this.canMakeAction()){

        }
        //TODO
        return true
    }
}
