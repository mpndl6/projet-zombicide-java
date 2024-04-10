package zombicide.item;

import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

/**
 * Class Item that represents all item object
 */
public abstract class Item implements Callable {
    protected Survivor survivor;

    /**
     * Construct an item
     * At creation an item has no survivor
     */
    public Item(){
        this.survivor = null;
    }

    /**
     * Adds a survivor to this item.
     * @param s The survivor to add.
     */
    public void addSurvivor(Survivor s) {
        this.survivor = s;
    }

    /**
     * removes a Survivor from the item
     */
    public void removeSurvivor(){
        this.survivor = null;
    }

    /**
     * Retrieves the survivor of the item
     * @return the survivor of the item
     */
    public Survivor getSurvivor() {
        return survivor;
    }

    /**
     * Executes the action associated with using this item.
     * This method prints a message indicating that the item can be used.
     */
    public abstract void use (Callable callable) throws Exception;
}
