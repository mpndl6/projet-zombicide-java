package zombicide.item.utility;

import zombicide.map.cell.Room;
import zombicide.map.cell.Street;
import zombicide.map.cell.util.CellType;
import zombicide.map.util.Location;
import zombicide.map.*;
import zombicide.map.util.Position;

public class MasterKey extends Utility{
    protected Map map;
    public MasterKey(Map map) {
        this.map = map;
    }

    /**
     * Uses the master key utility item to open a door at the specified location.
     * If the survivor is in a room cell, the method attempts to open the door.
     * @param l The location of the door to be opened.
     */
    public void use(Location l) {
        if (this.survivor.getCell() instanceof Room) {
            this.map.openDoorOfRoom(this.survivor.getCell(), l);
        }
        if (this.survivor.getCell() instanceof Street){
            Position poOfSurvivor = this.survivor.getCell().getPosition();
            if(l == Location.NORTH){
                this.map.openDoorOfRoom(map.getCell(new Position(poOfSurvivor.getX(),poOfSurvivor.getY()-1)),Location.SOUTH);
            }
            if(l == Location.SOUTH) {
                this.map.openDoorOfRoom(map.getCell(new Position(poOfSurvivor.getX(),poOfSurvivor.getY()+1)),Location.NORTH);
            }
            if(l == Location.EAST) {
                this.map.openDoorOfRoom(map.getCell(new Position(poOfSurvivor.getX()+1,poOfSurvivor.getY())),Location.WEST);
            }
            if(l == Location.WEST) {
                this.map.openDoorOfRoom(map.getCell(new Position(poOfSurvivor.getX()-1,poOfSurvivor.getY())),Location.EAST);
            }
        }
    }
}