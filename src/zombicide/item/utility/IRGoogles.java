package zombicide.item.utility;

import zombicide.map.Map;
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
    public void use(){
        Position p = this.survivor.getCell().getPosition();
        if(p.getX() + 1 < this.map.getWidth())
            System.out.printf(this.map.getCells()[p.getX() + 1][p.getY()].description());
        if(p.getX() - 1 >= 0)
            System.out.printf(this.map.getCells()[p.getX() - 1][p.getY()].description());
        if(p.getY() + 1 < this.map.getHeight())
            System.out.printf(this.map.getCells()[p.getX()][p.getY() + 1].description());
        if(p.getY() - 1 >= 0)
            System.out.printf(this.map.getCells()[p.getX()][p.getY() - 1].description());
    }
}