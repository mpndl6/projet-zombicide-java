package zombicide.action;

import zombicide.actor.survivor.Survivor;
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

    /**
     * Performs the action of searching for items in the current room.
     */
    @Override
    public void make() {
        Room currentRoom = (Room) survivor.getCell();
        if(currentRoom != null) {
            List<Item> itemsFound = currentRoom.getItems();
        }

    }
}
