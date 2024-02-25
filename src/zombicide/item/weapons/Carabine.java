package zombicide.item.weapons;

import zombicide.item.Weapon;
/**
 * The class Crowbar represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a Carabine weapon.
 */
public class Carabine extends Weapon {

    public Carabine(){
        super.damage=1;
        super.rangeMin=1;
        super.rangeMax=3;
        super.threshold=4;
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
