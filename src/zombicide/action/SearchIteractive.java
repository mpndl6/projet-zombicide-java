package zombicide.action;

import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.map.cell.Cell;

public class SearchIteractive extends Search {
    public SearchIteractive(Survivor s) {
        super(s);
    }

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
