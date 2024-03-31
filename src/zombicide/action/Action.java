package zombicide.action;

/**
 * Interface Action represents all the actions doable by the actors
 */
public interface Action {
    /**
     * Performs the action associated with this object.
     * This method should be implemented by concrete classes to define
     * specific behavior for the action.
     */
    public void make();

    /**
     * Gets the cost of the action that will be required
     * This method should be implemented by concrete classes
     */
    public int getCost();
}



