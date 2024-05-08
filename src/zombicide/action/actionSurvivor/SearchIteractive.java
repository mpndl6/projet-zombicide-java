package zombicide.action.actionSurvivor;

import zombicide.action.actionSurvivor.Search;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.map.cell.Cell;
/**
 * Represents an interactive search action performed by a Survivor.
 * This class extends the Search action and adds additional interactive functionality.
 */
public class SearchIteractive extends Search {
    /**
     * Constructs a new SearchIteractive action with the specified Survivor.
     *
     * @param s the Survivor associated with this action.
     */
    public SearchIteractive(Survivor s) {
        super(s);
    }

    /**
     * Performs the interactive search action.
     *
     * @param callable not used in this implementation.
     * @return true if he can make the action.
     */
    @Override
    public boolean make(Callable callable){
        if (!canMakeAction())
            return false;
        Cell survivorCell = survivor.getCell();
        if (survivor.getAllInBackpack().size() < Survivor.MAX_NB_ITEM) {
        } //TODO
        return true;
    }
}
