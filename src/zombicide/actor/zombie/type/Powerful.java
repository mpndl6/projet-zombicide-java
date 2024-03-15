package zombicide.actor.zombie.type;

import zombicide.actor.zombie.Zombie;

public class Powerful extends Zombie {
    public static final int POWERFUL_DAMAGES=2;
    public static final String POWERFUL_NN= "Powerful";

    public Powerful(){
        super(POWERFUL_NN,POWERFUL_DAMAGES,4);
    }
}
