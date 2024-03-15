package zombicide.actor.zombie.type;

import zombicide.actor.zombie.Zombie;

public class Walker extends Zombie{
    public static final int WALKER_DAMAGES=1;
    public static final String WALKER_NN="Walker";

    public Walker(){
        super(WALKER_NN,WALKER_DAMAGES,1);
    }


    
}
