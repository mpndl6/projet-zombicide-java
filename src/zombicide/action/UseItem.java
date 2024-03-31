package zombicide.action;

import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;

public class UseItem extends ActionSurvivor {
    /**
     * Constructs a new ActionSurvivor object with the specified Survivor.
     *
     * @param s the Survivor associated with this action.
     */
    public UseItem(Survivor s) {
        super(s);
    }
    /*
    * Executes the action of using the item currently held by the survivor associated with this action

    */
    @Override
    public void make() {
        Survivor survivor = getSurvivor();
        if(survivor.hasItemOnHand()) {
            Item item = survivor.getWhatINHand();
            item.use();
        }
    }
}
