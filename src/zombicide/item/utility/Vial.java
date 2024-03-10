package zombicide.item.utility;

import zombicide.item.Item;

public class Vial extends Utility {
    public Vial(){

    }

    /**
     * Uses the vial utility item to increase the life points of the survivor.
     * This method overrides the use method from the Utility class.
     */
    @Override
    public void use() {
        this.survivor.increaseLifePoints();
    }
}