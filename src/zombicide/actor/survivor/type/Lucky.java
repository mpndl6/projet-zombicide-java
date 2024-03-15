package zombicide.actor.survivor.type;
import zombicide.actor.survivor.Survivor;

public class Lucky extends Survivor {
    /**
     * Contruct a survivor with their name in parameter.
     * At creation, a survivor has a Pistol in hand
     * 5 life points, 0 XP, 0 action points et nothing in backpack
     *
     * @param name the nickname of the survivor
     */
    public Lucky(String name) {
        super(name);
    }

    /**

     * The lucky survivor rolls an extra die when attacking a zombie.
     * @param howMany The number of dice to throw.
     * @return The total result of the dice throws.
     */
    public int diceThrows(int howMany) {

            return super.diceThrows(howMany) + super.diceThrows(1);
        }
    }

