package zombicide.item;

import zombicide.actor.survivors.Survivor;

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

}