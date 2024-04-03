package zombicide.action;

import exception.NoSuchItemException;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.item.Item;
import zombicide.item.weapon.Weapon;

public class ActionAttackSurvivor extends ActionSurvivor {

    public ActionAttackSurvivor(Survivor s) {
        super(s);
    }
    /**
     * Verify if the survivor can attack or not( verify if he had a weapon in their hands)
     */
    @Override
    public boolean canMakeAction() {
        return this.survivor.getWhatINHand() instanceof Weapon;
    }

    /**
     * Performs the action of making the action attack by an survivor;
     */
    @Override
    public boolean make(Callable callable) throws Exception {
        if(!canMakeAction()){
            throw new NoSuchItemException("There's no weapon in their hand.");
        }
        Item weapon = this.survivor.getWhatINHand();
        weapon.use();
        return  true;
    }

}
