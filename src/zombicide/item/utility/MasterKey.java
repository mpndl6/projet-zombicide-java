package zombicide.item.utility;

import zombicide.map.cell.Room;
import zombicide.map.cell.util.CellType;
import zombicide.map.util.Location;

public class MasterKey extends Utility{

    public MasterKey() {}

    /**
     * Uses the master key utility item to open a door at the specified location.
     * If the survivor is in a room cell, the method attempts to open the door.
     * @param l The location of the door to be opened.
     */
    public void use(Location l) {
        if (this.survivor.getCell().getTypeOfCell() == CellType.ROOM){
            Room room = (Room) this.survivor.getCell();
            room.openDoor(l);
        }
    }
}