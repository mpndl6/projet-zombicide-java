package zombicide.item.weapons;

import zombicide.item.Weapon;

/**
 * The class crowbar represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a crowbar weapon.
 */
public class crowbar extends Weapon{
    /**
     * Default constructor for the crowbar class.
     * Initializes the attributes specific to a crowbar weapon.
     */
    public crowbar(){
        this.name="crowbar";
        this.damage=1;
        this.rangeMin=0;
        this.rangeMax=0;
        this.threshold=4;
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
