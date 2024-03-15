package zombicide.item;

import zombicide.actor.survivor.Survivor;

public abstract class Item {
    protected Survivor survivor;

    public Item(){
    }

    /**
     * Adds a survivor to this item.
     * @param s The survivor to add.
     */
    public void addSurvivor(Survivor s) {
        this.survivor = s;
    }

    /**
     * @return the survivor of the item
     */
    public Survivor getSurvivor() {
        return survivor;
    }
}