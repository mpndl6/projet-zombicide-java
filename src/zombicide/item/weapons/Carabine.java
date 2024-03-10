package zombicide.item.weapons;

import zombicide.item.Weapon;
/**
 * The class Crowbar represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a Carabine weapon.
 */
public class Carabine extends Weapon {

    /**
     * Construct a new Carabine
     * minimum range : 1
     * maximum range : 3
     * damage : 1
     * threshold : 4
     */
    public Carabine(){
        super(1,3,1,4);
    }
    /**
     * Abstract method to determine the number of dice rolls needed for this weapon.
     * @return The number of dice rolls needed for this weapon.
     */
    @Override
    public int howManyThrows() {
        return 2;
    }
}
