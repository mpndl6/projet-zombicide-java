package zombicide.map.cell;
import java.util.*;

import zombicide.map.util.*;
import zombicide.item.*;
import zombicide.map.cell.util.*;

/**
 * Class of the room present on Map. The rooms are cells with particular features.
 */
public class Room extends Cell {

    protected Map<Location,Boolean> doors;
    protected CellType cellType;

    /**
     * Creates a Room with 0 item at creation and no doors open
     */
    public Room() {
    super();
    this.cellType = CellType.ROOM;
    super.items = new ArrayList<Item>();
    this.doors = new HashMap<Location,Boolean>();

    List<Location> locations = this.locationOfDoors();

    for(Location l : locations) {
        this.doors.put(l,false);
    }
}

    /**
     * get type of cell
     *
     *@return type of cell
     */
    public CellType getTypeOfCell() {
        return this.cellType;
    }

    /**
     * Gives a description of the cell. The number of actors, which door is open of not etc.
     * @return a description of the Cell
     */
    @Override
    public String description() {
        return "Type of cell :" + this +"\n" + "number of survivors :" + this.howManySurvivors() + " \n " + " number of zombies:" + this.howManyZombies() + "\n"+" number of objects:" + this.getNbItem() +"\n"+" North door"+this.isOpen(Location.NORTH)+" South door"+this.isOpen(Location.SOUTH)+" East door"+this.isOpen(Location.EAST)+" West door"+this.isOpen(Location.WEST);
    }

    /**
     * Determines the possible locations for doors in the room.
     *
     * @return A list of possible door locations.
    */
    protected List<Location> locationOfDoors() {
        List<Location> locations =new ArrayList<Location>();
        locations.add(Location.NORTH);
        locations.add(Location.SOUTH);
        locations.add(Location.EAST);
        locations.add(Location.WEST);
        return locations;
    }


    /**
     * Adds an item to the room.
     * @param i The item to be added.
     */
    public void addItem(Item i) {
        super.items.add(i);
    }

    /**
     * Removes an item from the room.
     *
     * @param i The item to be removed.
     */
    public void removeItem(Item i) {
        super.items.remove(i);
    }


    /**
     * Tell is the door at location l is open or not
     * @param l the location of the door
     * @return true isf the door is open
     */
    public Boolean isOpen(Location l){
    return doors.get(l);
    }

    /**
     * Opens a specific door in the room.
     *
     * @param l The location of the door to be opened.
     */
    public void openDoor(Location l) {
            doors.put(l,true);

    }
    public boolean canFight() {
    	return true;
    }

    /**
     * Returns the description of the cell
     * @return the description of the cell
     */
    public String toString(){
        return "R";

    }

    /**
     * Search a random intem in the Cell (if it's a street it will automatically be emtpy!) and returns it.
     * @return a random item found in the Cell
     */
    public static Item searchForItem(Cell cell) {
        List<Item> itemsOfCell = cell.getItems();
        if (!itemsOfCell.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(itemsOfCell.size());
            return itemsOfCell.get(index);
        } else {
            return null;
        }
    }


}


