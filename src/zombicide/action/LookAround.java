package zombicide.action;

import exception.NoSuchItemException;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

/**
 * The LookAround class represents an action where a Survivor looks around.
 * This action allows the Survivor to get a description of the cell they are currently in.
 * This class extends the ActionSurvivor abstract class.
 */
public class LookAround extends ActionSurvivor {

/**
 * Constructs a new LookAround object with the specified Survivor.
 * @param s the Survivor associated with this action.
 */
public LookAround(Survivor s) {
    super(s);
    this.cost = 0;
}

/**
 *
 * Checks if the Survivor can perform the action of looking around.
 * @return true if the Survivor can perform the action, false otherwise.
 */
public boolean canMakeAction(){
    return true;
}

/**
 * Performs the action of looking around.
 * This method calls the description method of the cell the Survivor is currently in.
 * It overrides the methode make of the superclass
 * @param callable A callable object
 * @return true if the action was successfully performed, false otherwise
 */
@Override
public boolean make(Callable callable){
    if(canMakeAction()) {
        this.survivor.getCell().description();
        return true;
    }
    return false;
}
}
