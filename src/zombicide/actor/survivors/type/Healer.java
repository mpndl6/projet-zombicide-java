package zombicide.actor.survivors.type;

import zombicide.actor.survivors.Survivor;

public class Healer extends Survivor {
    /**
     * Contruct a survivor with their name in parameter.
     * At creation, a survivor has a Pistol in hand
     * 5 life points, 0 XP, 0 action points et nothing in backpack
     *
     * @param name the nickname of the survivor
     */
    public Healer(String name) {
        super(name);
    }

    /**
     * Method allowing the healer to heal a target survivor.
     * This action restores 1 hp to the target survivor (including the healer itself).
     * @param survivor The survivor to be healed.
     */
    public void heal(Survivor survivor){
        survivor.increaseHP();
    }

}
