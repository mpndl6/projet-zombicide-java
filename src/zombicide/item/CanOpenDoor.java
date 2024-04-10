package zombicide.item;

import exception.IsWallException;
import zombicide.map.util.Location;
import zombicide.map.*;

/**
 * This Interface is for the object that can open a door
 * Each object that can open a door will implement this Interface
 */
public interface CanOpenDoor {

    /**
     * Permits to open a door
     * @param location the location of the door wanted
     */
    public void open(Location location) throws IsWallException;

    /**
     * Set a map to the master key
     * @param map the map wanted
     */
    public void setMap(Map map);

}
