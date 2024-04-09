package zombicide.item.utility;

import zombicide.callable.Callable;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.util.Position;

public class CoverUp extends Utility{
    protected Map map;
    public CoverUp(Map map){
        this.map = map;
    }

    public void use(Callable callable) {
        Position pos = (Position) callable;
        Cell cell = map.getCell(pos);

        if (cell.containsZombie()) {
            System.out.println("You are camouflaged as a zombie. The zombie ignores you.");
        } else {
            System.out.println("There are no zombies in this cell.");
        }
    }

    public String toString(){
        return "Cover Up";
    }


}
