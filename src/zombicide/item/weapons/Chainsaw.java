package zombicide.item.weapons;

import zombicide.item.Weapon;
/**
 * The class Crowbar represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a Chainsaw weapon.
 */
public class Chainsaw extends Weapon {

    public Chainsaw(){
        super.damage=3;
        super.rangeMin=0;
        super.rangeMax=0;
        super.threshold=5;
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
