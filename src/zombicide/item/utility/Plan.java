package zombicide.item.utility;
import grid.Grid;
import zombicide.callable.Callable;
import zombicide.map.*;

public class Plan extends Utility {
    protected Map map;

    public Plan(Map m){
        this.map = m;
    }

    /**
     * Uses the plan utility item to display the associated map.
     * This method overrides the use method from the Utility class.
     */
    @Override
    public void use() {
        Grid grid= new Grid(this.map, 5);
        grid.displayGrid();
    }

    /**
     * @return a description of the item
     */
    public String toString(){
        return "Plan";
    }
}