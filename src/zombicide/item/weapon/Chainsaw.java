package zombicide.item.weapon;

import zombicide.callable.Callable;

/**
 * The class Chainsaw represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a Chainsaw weapon.
 */
public class Chainsaw extends Weapon  {

    /**
     * Construct a new Chainsaw
     * minimum range : 0
     * maximum range : 0
     * damage : 3
     * threshold : 5
     */
    public Chainsaw(){
        super(0,0,3,5);
    }
    /**
     * Abstract method to determine the number of dice rolls needed for this weapon.
     * @return The number of dice rolls needed for this weapon.
     */
    @Override
    public int howManyThrows() {
        return 2;
    }

    /**
     * Performs the action of using the chainsaw.
     * This method is called when a survivor uses the chainsaw as a utility item.
     *
     * @param callable the callable object used for the action(Zombie).
     */
    @Override
    public void use(Callable callable){

    }

    /**
     * @return a description of the item
     */
    public String toString(){
        return "Chainsaw";
    }
}
