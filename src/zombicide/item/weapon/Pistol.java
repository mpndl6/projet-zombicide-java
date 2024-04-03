package zombicide.item.weapon;

import exception.IsWallException;
import zombicide.item.CanOpenDoor;
import zombicide.map.Map;
import zombicide.map.util.Location;

/**
 * The class Pistol represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a Pistol weapon.
 */
public class Pistol extends Weapon implements CanOpenDoor {

    protected Map map;

    /**
     * Construct a new Pistol
     * minimum range : 0
     * maximum range : 1
     * damage : 1
     * threshold : 4
     */
    public Pistol(){
        super(0,1,1,4);
    }
    /**
     * Abstract method to determine the number of dice rolls needed for this weapon.
     * @return The number of dice rolls needed for this weapon.
     */
    @Override
    public int howManyThrows() {
        return 1;
    }

    /**
     * @return a description of the item
     */
    public String toString(){
        return "Pistol";
    }


    @Override
    public void open(Location location) throws IsWallException {
        this.map.openDoorOfRoom(this.survivor.getCell(), location);
    }
}
