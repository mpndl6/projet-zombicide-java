package zombicide.item.weapon;

import exception.IsWallException;
import zombicide.callable.Callable;
import zombicide.item.CanOpenDoor;
import zombicide.map.Map;
import zombicide.map.util.Location;

/**
 * The class Crowbar represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a Crowbar weapon.
 */
public class Crowbar extends Weapon implements CanOpenDoor {

    protected Map map;

    /**
     * Construct a new Crowbar
     * minimum range : 0
     * maximum range : 0
     * damage : 1
     * threshold : 4
     */
    public Crowbar(){
        super(0,0,1,4);
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
     * Gives a description of the utility
     * @return a description of the item
     */
    public String toString(){
        return "Crowbar";
    }

    /**
     *
     */
    @Override
    public void use(Callable callable){

    }

    public void setMap(Map map){
        this.map = map;
    }

    /**
     * Open a door with a crowbar. It makes noise.
     * @param location of the wanted door
     */
    @Override
    public void open(Location location) throws IsWallException {
        System.out.println("Give it all.\n");
        this.survivor.getGame().getMap().openDoorOfRoom(this.survivor.getCell(), location);
        super.survivor.getCell().makeNoise(); //quand une arme est utilisée pour ouvrir une porte, le niveau de bruit de la cellule augmente
        System.out.println("It's open. You can go.");
    }

    }

