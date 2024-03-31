package zombicide.action;

import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;
import zombicide.map.cell.Room;

import java.util.List;

public class Search extends ActionSurvivor {

    public Search(Survivor s) {
        super(s);
        this.cost = 1;
    }

    @Override
    public void make() {
        Room currentRoom = (Room) survivor.getCell();
        if(currentRoom != null) {
            List<Item> itemsFound = currentRoom.getItems();
        }

    }
}
