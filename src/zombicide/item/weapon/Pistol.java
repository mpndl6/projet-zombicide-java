package zombicide.item.weapon;

import exception.IsWallException;
import zombicide.callable.Callable;
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

    /**
     *
     */
    @Override
    public void use(Callable callable){

    }

    /**
     * Open a door with a pistol. It makes a lot of noise
     * @param location of the door wanted
     */
    @Override
    public void open(Location location) throws IsWallException {
        System.out.println("Please step aside. It's gonna bomb \n");
        for (int i = 0; i < 3; i++)
            System.out.print(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("***BOOM!***\n");
        this.map.openDoorOfRoom(this.survivor.getCell(), location);
        super.survivor.getCell().makeNoise();
        super.survivor.getCell().makeNoise(); //x2
        System.out.println("It's open. You can go.\n Don't burn your hand buddy!\n Remember this has made a lot of noise");
    }
}
