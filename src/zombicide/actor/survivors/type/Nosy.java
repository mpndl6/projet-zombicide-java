package zombicide.actor.survivors.type;

import zombicide.actor.survivors.Survivor;

public class Nosy extends Survivor {

    /**
     * Contruct a survivor with their name in parameter.
     * At creation, a survivor has a Pistol in hand
     * 5 life points, 0 XP, 0 action points et nothing in backpack
     *
     * @param name the nickname of the survivor
     */
    public Nosy(String name) {
        super(name);
    }

    //La premiere fouille est gratuite(ne coute pas de point d'action)
}
