package zombicide.item;

import exception.IsWallException;
import zombicide.map.util.Location;

public interface CanOpenDoor {

    /**
     *
     */
    public void open(Location location) throws IsWallException;
}
