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

}
