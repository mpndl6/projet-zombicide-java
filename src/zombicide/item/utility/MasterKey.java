package zombicide.item.utility;

import zombicide.callable.Callable;
import exception.IsWallException;
import zombicide.item.CanOpenDoor;
import zombicide.map.util.Location;
import zombicide.map.*;

/**
 * Class of the MasterKey. A MasterKey can open any door in a Map
 */
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
    @Override
    public void use(Callable callable) throws Exception{
        this.open((Location)callable);
    }

    /**
     * Gives a description of the utility
     * @return a description of the item
     */
    public String toString(){
        return "MasterKey";
    }

    /**
     * Open a door
     * @param location of the wanted door
     */
    @Override
    public void open(Location location) throws IsWallException {
        System.out.println("Ok Master.");
        this.map.openDoorOfRoom(this.survivor.getCell(), location);
        System.out.println("It's open. You can go.");
    }
}