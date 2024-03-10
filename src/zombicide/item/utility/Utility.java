package zombicide.item.utility;

import zombicide.item.Item;

public abstract class Utility extends Item {
    public Utility(){
    }

    /**
     * Defines the action of using the utility item.
     * Subclasses should override this method to specify the behavior of the specific utility item.
     */
    public void use() {}
}