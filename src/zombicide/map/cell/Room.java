package zombicide.map.cell;
import java.util.*;

import zombicide.actor.survivors.Survivor;
import zombicide.map.util.*;
import zombicide.item.*;
import zombicide.map.cell.util.*;

public class Room extends Cell {

    protected List<Item> items;
    protected Map<Location,Boolean> doors;
    protected int widthOfMap;
    protected int heightOfMap;
    protected CellType cellType;

    public Room(Position p , int w , int h) {
        super(p);
        this.cellType = CellType.ROOM;
        this.widthOfMap = w;
        this.heightOfMap = h;
        this.items = new ArrayList<Item>();
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
     * Determines the possible locations for doors in the room.
     *
     * @return A list of possible door locations.
    */
    public List<Location> locationOfDoors() {
        int a = this.getPosition().getX();
        int b = this.getPosition().getY();
        List<Location> locations =new ArrayList<Location>();


        if(b > 0)
            locations.add(Location.NORTH);
        if(b < this.heightOfMap-1)
            locations.add(Location.SOUTH);
        if(a > 0)
            locations.add(Location.EAST);
        if(a < this.widthOfMap-1)
            locations.add(Location.WEST);
        return locations;
    }

    /**
     *
     * @param l
     * @return
     */
    public boolean hasDoor(Location l){
        if (this.doors.containsKey(l))
            return true;
        return false;
    }

    /**
     * Checks if it is possible to leave the room through a specific door.
     *
     * @param l The location of the door.
     * @return True if the door is open, false otherwise.
     */
    public boolean canLeaveByDoor(Location l) {
        if(!this.doors.containsKey(l))
            return false;
        return this.doors.get(l).isOpen();
    }

    /**
     * Returns the number of doors in the room.
     *
     * @return The number of doors.
     */
    public int getNbDoors() {
        return this.doors.size();
    }

    /**
     * Returns the number of items in the room.
     *
     * @return The number of items.
     */
    public int getNbitems() {
        return this.items.size();
    }

    public void setDoor(Door d, Location location){
        this.doors.put(location,d);
    }

/**
 *
 */
public Door getDoor(Location l){
    return doors.get(l);
}

    /**
     * Adds an item to the room.
     *
     * @param i The item to be added.
     */
    public void addItems(Item i) {
        this.items.add(i);
    }

    /**
     * Removes an item from the room.
     *
     * @param i The item to be removed.
     */
    public void removeItems(Item i) {
        this.items.remove(i);
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
        if (this.doors.containsKey(l)) {
            doors.put(l,true);
        }
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

}


