package zombicide.actor.zombies.type;
import zombicide.actor.zombies.Zombie;

/**
 * The abomination represents a type of zombie called abomination in the zombicide game
 */
public class Abomination extends Zombie {
    public static final int ABOMINATION_DAMAGES = 3;
    public static final String ABOMINATION_NN = "Abomination";

    /**
     *Constructs a new abomination zombie with default parameters
     */
    public Abomination() {
        super(ABOMINATION_NN, ABOMINATION_DAMAGES, 6);
    }
}