package zombicide.item.weapons;

import zombicide.item.Weapon;
/**
 * The class crowbar represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a pistol weapon.
 */
public class pistol extends Weapon {

    public pistol(){
        this.name="pistol";
        this.damage=1;
        this.rangeMin=0;
        this.rangeMax=1;
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
