package zombicide.map;

import zombicide.action.Action;
import zombicide.action.OpenDoor;
import zombicide.action.TakeInHand;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.map.cell.Cell;

import java.util.*;

public class TrainingMap3 extends Map{

    public static final int TrainingMap3_Width = 5;
    public static final int TrainingMap3_Height = 5;

    /**
     * It creates a Map with width and heigth
     * known at creation
     * the Map is initialised at creation

     * @param listRooms   list of specialrooms
     * @param listStreets list of specialstreets
     */
    public TrainingMap3(List<Cell> listRooms, List<Cell> listStreets) {
        super(TrainingMap3_Width, TrainingMap3_Height, listRooms, listStreets);
    }

}
