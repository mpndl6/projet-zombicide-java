package zombicide.item.weapon;

import zombicide.actor.zombie.Zombie;
import zombicide.item.Item;
import zombicide.map.util.Position;

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

    /**
     * Returns how much damage the weapon inflicts
     * @return the damage the weapon can inflict
     */
    public int getHowMushDamage(){
        return this.damage;
    }

    /**
     * Returns the minimums range of the weapon
     * @return the minimum range of the weapon
     */
    public int getRangeMin(){
        return rangeMin;
    }

    /**
     * Return the maximum range of the weapon
     * @return the maximum range of the weapon
     */
    public int getRangeMax() {
        return rangeMax;
    }

    /**
     * Returns the threshold of the weapon
     * @return the threshold of the weapon
     */
    public int getThreshold(){
        return threshold;
    }

    /**
     * Increase the damage power of the current weapon
     */
    public void increaseDamage(int i){
        this.damage = this.damage +i;
    }

    /**
     * Gives a description of the item
     * @return a description of the item
     */
    public abstract String toString();

    public boolean attack(Zombie zombie){
        Position posOfSuvivor = this.survivor.getCell().getPosition();
        Position posOfZombie = zombie.getCell().getPosition();
        int dX = posOfSuvivor.getX() - posOfZombie.getX();
        int dY = posOfSuvivor.getY() - posOfZombie.getY();
        if(dY < 0){
            dY = dY*(-1);
        }
        if(dX < 0){
            dX = dX*(-1);
        }

        if(posOfSuvivor.getX() == posOfZombie.getX() && this.survivor.getGame().doorsBetween(posOfSuvivor,posOfZombie)){
            if(this.rangeMax >= dX && dX >= this.rangeMin){
                int resDice = this.survivor.diceThrows(this.howManyThrows());
                if(resDice >= this.threshold){
                    for(int i = 0 ; i < this.damage ; i++){
                        zombie.takeDamage();
                    }
                    this.survivor.getCell().makenoise();
                    return true;
                }
            }
        }
        if(posOfSuvivor.getY() == posOfZombie.getY() && this.survivor.getGame().doorsBetween(posOfSuvivor,posOfZombie)){
            if(this.rangeMax >= dY && dY >= this.rangeMin){
                int resDice = this.survivor.diceThrows(this.howManyThrows());
                if(resDice >= this.threshold){
                    for(int i = 0 ; i < this.damage ; i++){
                        zombie.takeDamage();
                    }
                    this.survivor.getCell().makenoise();
                    return true;
                }
            }
        }
        System.out.println("attaque impossible");
        return false;
    }
}
