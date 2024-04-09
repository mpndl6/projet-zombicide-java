package zombicide.item.utility;

import zombicide.callable.Callable;
import zombicide.map.Map;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

public class IRGoogles extends Utility {
    protected Map map;

    public IRGoogles(Map m){
        this.map = m;
    }

    /**
     * Uses the IR goggles utility item to view adjacent map cells.
     * This method displays information about adjacent cells relative to the survivor's current position.
     */
    public void use(Callable callable){
        Position p = this.survivor.getCell().getPosition();
        System.out.println("*****************************************************");
        if(p.getX() + 1 < this.map.getWidth())
            System.out.printf("*** WEST\n"+this.map.getCells()[p.getX() + 1][p.getY()].description()+ " ***");
        if(p.getX() - 1 >= 0)
            System.out.printf("*** EAST\n"+this.map.getCells()[p.getX() - 1][p.getY()].description()+" ***");
        if(p.getY() + 1 < this.map.getHeight())
            System.out.printf("*** SOUTH\n"+this.map.getCells()[p.getX()][p.getY() + 1].description()+" ***");
        if(p.getY() - 1 >= 0)
            System.out.printf("*** NORTH\n"+this.map.getCells()[p.getX()][p.getY() - 1].description()+" ***");
        System.out.println("*****************************************************");
    }

    /**
     * @return a description of the item
     */
    public String toString(){
        return "IRGoogles";
    }
}