package zombicide.item.utility;

import zombicide.action.actionSurvivor.OpenDoor;
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
        System.out.println("Great! You have the correct item on hand to open a door. Now when you choose th action 'open' you will be able to open any openable door ;).");
    }

    /**
     * Retrives the map of the item
     * @return the map of the Master key
     */
    public Map getMap(){
        return this.map;
    }

    /**
     * Set a map to the master key
     * @param map the map wanted
     */
    public void setMap(Map map){
        this.map = map;
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