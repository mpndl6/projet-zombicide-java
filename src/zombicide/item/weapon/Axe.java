package zombicide.item.weapon;

import exception.IsWallException;
import zombicide.callable.Callable;
import zombicide.item.CanOpenDoor;
import zombicide.map.Map;
import zombicide.map.util.Location;

/**
 * The class Axe represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a Axe weapon.
 */
public class Axe extends Weapon implements CanOpenDoor {

    protected Map map;

    /**
     * Construct a new Axe
     * minimum range : 0
     * maximum range : 0
     * damage : 2
     * threshold : 4
     */
    public Axe(){
        super(0,0,2, 4);
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
        return "Axe";
    }

    /**
     *
     */
    @Override
    public void use(Callable callable){

    }

    /**
     * Open the door with the Axe. It will make noise
     * @param location of the door wanted
     */
    @Override
    public void open(Location location) throws IsWallException {
        System.out.println("I hope you're strong enough? \n");
        if(this.survivor.getLifePoints()<2) {
            System.out.println("You dont have enough strength :(.\n You will break your arm.");
            return;
        }
        System.out.println("Ok it's going to make some noise around here. Give it all.\n");
        for (int i = 0; i < 2; i++)
            System.out.print(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The door it's broke. You can go.");
        this.map.openDoorOfRoom(this.survivor.getCell(), location);
        this.survivor.getCell().makeNoise(); // quand une arme est utilisée pour ouvrir une porte, le niveau de bruit de la cellule augmente
    }
}
