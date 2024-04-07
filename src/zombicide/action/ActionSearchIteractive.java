package zombicide.action;

import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;
import zombicide.map.cell.Cell;

public class ActionSearchIteractive extends ActionSearch{
    public ActionSearchIteractive(Survivor s) {
        super(s);
    }

    @Override
    public boolean make(Callable callable) throws Exception{
        if (!canMakeAction())
            return false;
        Cell survivorCell = survivor.getCell();

    }
}
