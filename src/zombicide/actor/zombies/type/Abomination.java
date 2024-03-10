package zombicide.actor.zombies.type;
import zombicide.actor.zombies.Zombie;
public class Abomination extends Zombie {
    public static final int ABOMINATION_DAMAGES = 2;
    public static final String ABOMINATION_NN = "Abomination";

    public Abomination() {
        super(ABOMINATION_NN, ABOMINATION_DAMAGES);
    }
}