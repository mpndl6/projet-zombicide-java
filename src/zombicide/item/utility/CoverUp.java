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

    /**
     * Uses the camouflage ability to disguise as a zombie in the specified cell.
     *
     * @param callable the position of the cell where to use the camouflage ability.
     */

    public void use(Callable callable) {
        Position pos = (Position) callable;
        Cell cell = map.getCell(pos);

        if (cell.containsZombie()) {
            System.out.println("You are camouflaged as a zombie. The zombie ignores you.");
        } else {
            System.out.println("There are no zombies in this cell.");
        }
    }

    /**
     * Returns a textual representation of the camouflage object.
     * This method is used to obtain a textual description of the object when it is converted to a string.
     *
     * @return A string representing the camouflage object.
     */

    public String toString(){
        return "Cover Up";
    }


}
