package zombicide.item.weapon;

/**
 * The class Crowbar represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a Axe weapon.
 */
public class Axe extends Weapon {

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
}
