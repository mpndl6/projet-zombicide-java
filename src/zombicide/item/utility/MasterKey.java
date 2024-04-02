package zombicide.item.utility;

import zombicide.callable.Callable;
import exception.IsWallException;
import zombicide.item.CanOpenDoor;
import zombicide.map.util.Location;
import zombicide.map.*;

public class MasterKey extends Utility implements CanOpenDoor {
    protected Map map;
    public MasterKey(Map map) {
        this.map = map;
    }

    /**
     * Uses the master key utility item to open a door at the specified location.
     * If the survivor is in a room cell, the method attempts to open the door.
     * @param callable The location of the door to be opened.
     */
    public void use(Callable callable){
        this.open((Location)callable);
    }

    /**
     * @return a description of the item
     */
    public String toString(){
        return "MasterKey";
    }

    /**
     *
     * @param location
     */
    @Override
    public void open(Location location) {
        try {
            this.map.openDoorOfRoom(this.survivor.getCell(), location);
        }
        catch(IsWallException iw){
            System.out.println(iw.getMessage());
        }
    }
}