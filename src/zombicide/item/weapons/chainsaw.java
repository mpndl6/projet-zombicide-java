package zombicide.item.weapons;

import zombicide.item.Weapon;
/**
 * The class crowbar represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a chainsaw weapon.
 */
public class chainsaw extends Weapon {

    public chainsaw(){
        this.name="chainsaw";
        this.damage=3;
        this.rangeMin=0;
        this.rangeMax=0;
        this.threshold=5;
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
