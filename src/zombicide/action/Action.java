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
}



