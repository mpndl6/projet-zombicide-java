package zombicide.actor.zombie.type;

import zombicide.action.Action;
import zombicide.actor.zombie.Zombie;
import zombicide.callable.Callable;

public class Walker extends Zombie{
    public static final int WALKER_DAMAGES=1;
    public static final String WALKER_NN="Walker";

    public Walker(){
        super(WALKER_NN,WALKER_DAMAGES,1);
    }

    public void makeAction(Action action, Callable callable){
        action.make(callable);
        action.make(callable);
    }
}
