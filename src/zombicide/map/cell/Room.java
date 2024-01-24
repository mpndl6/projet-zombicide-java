package zombicide.map.cell;
import java.util.*;
import zombicide.map.util.*;
import zombicide.item.*;

public class Room extends Cell {

    protected List<Item> items;
    protected Map<Location,Door> doors;
    protected int widthOfMap;
    protected int heightOfMap;

    public Room(Position p , int w , int h) {
        super(p);
        this.widthOfMap = w;
        this.heightOfMap = h;
        this.items = new ArrayList<Item>();
        this.doors = new HashMap<Location,Door>();

        List<Location> locations = this.locationOfDoors();

        for(Location l : locations) {
            this.doors.put(l,new Door(l));
        }
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
     * Opens a specific door in the room.
     *
     * @param l The location of the door to be opened.
     */
    public void openDoor(Location l) {
        if(this.doors.containsKey(l))
            this.doors.get(l).open();
    }


}
