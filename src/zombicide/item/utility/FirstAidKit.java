package zombicide.item.utility;

import zombicide.actor.survivors.Survivor;

public class FirstAidKit extends Utility {

    public FirstAidKit(){}

    /**
     * Uses the first aid kit utility item to increase the life points of the specified survivor.
     * @param s The survivor to whom the first aid kit is being used.
     */
    public void use(Survivor s) {
        s.increaseLifePoints();
    }

}
