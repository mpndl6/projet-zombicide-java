package zombicide.actor.zombies.type;

import zombicide.actor.zombies.Zombie;

public class Runner extends Zombie{
    public static final int RUNNER_DAMAGES=1;
    public static final String RUNNER_NN = "Ruuner";
    public Runner(){
        super(RUNNER_NN,RUNNER_DAMAGES,2);
    }

    //methodes action

}
