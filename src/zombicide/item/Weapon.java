package zombicide.item;

/**
 * The abstract class Weapon represents a type of item usable as a weapon in the game Zombicide.
 * It extends the Item class and defines attributes common to all weapons.
 */
public abstract class Weapon extends Item {
    /** The minimum range of the weapon. */
    protected int rangeMin;
    /** The maximum range of the weapon. */
    protected int rangeMax;
    /** The damage inflicted by the weapon. */
    protected int damage;
    protected int threshold;

    public Weapon(){

    }
    /**
     * Abstract method to determine the number of dice rolls needed for this weapon.
     * @return The number of dice rolls needed for this weapon.
     */
    public abstract int howManyThrows();



}
