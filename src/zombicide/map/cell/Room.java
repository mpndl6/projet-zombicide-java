package zombicide.cell;

public class Room extends Cell {

    protected List<Item> items;
    protected Map<Location,Door> doors;
    protected int width;
    protected int height;

    public Room(Position p , int w , int h) {
        super(p);
        this.width = w;
        this.height = h;
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
        if(b < this.height-1)
            locations.add(Location.SOUTH);
        if(a > 0)
            locations.add(Location.EAST);
        if(a < this.width-1)
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
    
}
