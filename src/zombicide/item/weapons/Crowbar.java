package zombicide.item.weapons;

import zombicide.item.Weapon;

/**
 * The class Crowbar represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a Crowbar weapon.
 */
public class Crowbar extends Weapon{
    /**
     * Default constructor for the Crowbar class.
     * Initializes the attributes specific to a Crowbar weapon.
     */
    public Crowbar(){
        super.damage=1;
        super.rangeMin=0;
        super.rangeMax=0;
        super.threshold=4;
    }
    /**
     * Abstract method to determine the number of dice rolls needed for this weapon.
     * @return The number of dice rolls needed for this weapon.
     */
    @Override
    public int howManyThrows() {
        return 1;
    }
}
