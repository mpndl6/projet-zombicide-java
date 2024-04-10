package zombicide.item;

import exception.IsWallException;
import zombicide.map.util.Location;
import zombicide.map.*;

public interface CanOpenDoor {

    /**
     *
     */
    public void open(Location location) throws IsWallException;

    /**
     *
     */
    public void setMap(Map map);
}
