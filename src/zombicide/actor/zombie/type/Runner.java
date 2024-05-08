package zombicide.actor.zombie.type;

import zombicide.actor.zombie.Zombie;

/**
 * Represents a type of zombie known as a Runner.
 * Runners are a type of zombie in the game Zombicide.
 *
 */
public class Runner extends Zombie{
    public static final int RUNNER_DAMAGES=1;
    public static final String RUNNER_NN = "Runner";

    /**
     * Constructs a new Runner zombie with default attributes.
     * The Runner zombie has the name "Runner", inflicts a default damage of 1,
     * and has a lifePoint of 2.
     */
    public Runner(){
        super(RUNNER_NN,RUNNER_DAMAGES,2);
    }

    //methodes action

}
