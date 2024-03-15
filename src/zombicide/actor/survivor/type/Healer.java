package zombicide.actor.survivor.type;

import zombicide.actor.survivor.Survivor;

public class Healer extends Survivor {
    /**
     * Construct a survivor with their name in parameter.
     * At creation, a survivor has a Pistol in hand
     * 5 life points, 0 XP, 0 action points et nothing in backpack
     *
     * @param name the nickname of the survivor
     */
    public Healer(String name) {
        super(name);
    }

    /**
     * Method allowing the healer to heal a target survivor and themselves.
     * This action restores 1 hp to the target survivor (including the healer itself).
     * @param survivor The survivor to be healed.
     */
    public void heal(Survivor survivor){
        this.increaseLifePoints();
        survivor.increaseLifePoints();
    }

}
