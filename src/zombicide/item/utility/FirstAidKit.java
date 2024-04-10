package zombicide.item.utility;

import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

/**
 * Class of FirstAidKit. Useful to heal a survivor
 */
public class FirstAidKit extends Utility {

    /**
     * Construct a FirstAidKit
     */
    public FirstAidKit(){
        super();
    }

    /**
     * Uses the first aid kit utility item to increase the life points of the specified survivor.
     * @param callable survivor to whom the first aid kit is being used.
     */
    public void use(Callable callable) {
        ((Survivor)callable).increaseLifePoints();
    }

    /**
     * Gives a description of the item
     * @return a description of the item
     */
    public String toString(){
        return "FirstAidKit";
    }

}
