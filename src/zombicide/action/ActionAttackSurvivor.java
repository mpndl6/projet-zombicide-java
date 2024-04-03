package zombicide.action;

import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.weapon.Weapon;

public class ActionAttackSurvivor extends ActionSurvivor {

    public ActionAttackSurvivor(Survivor s) {
        super(s);
    }

    @Override
    public boolean canMakeAction() {
        return this.survivor.getWhatINHand() instanceof Weapon;
    }

    /**
     * Performs the action of making noise by an survivor in the current room.
     */
    @Override
    public boolean make(Callable callable) throws Exception {
       return false;
    }

}
