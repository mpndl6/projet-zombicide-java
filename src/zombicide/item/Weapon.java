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

    /**
     * Construct a new weapon
     * @param rMin minimum range of the weapon
     * @param rMax maximum range of the weapon
     * @param damage damage inflicted by the weapon
     * @param threshold threshold
     */
    public Weapon(int rMin, int rMax, int damage, int threshold){
        this.damage=damage;
        this.threshold=threshold;
        this.rangeMax=rMax;
        this.rangeMin=rMin;
    }

    /**
     * Abstract method to determine the number of dice rolls needed for this weapon.
     * @return The number of dice rolls needed for this weapon.
     */
    public abstract int howManyThrows();



}
