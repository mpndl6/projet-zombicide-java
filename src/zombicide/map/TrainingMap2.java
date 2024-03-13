package zombicide.map;

import zombicide.actor.Actor;
import zombicide.map.cell.Cell;
import zombicide.map.util.Location;

import java.util.List;

public class TrainingMap2 extends Map {

    public static final int widthOfTrainingMap = 5;
    public static final int heightOfTrainingMap = 5;

    /**
     * It creates a Map with width and heigth
     * known at creation
     * the Map is initialised at creation
     * @param listRooms   list of specialrooms
     * @param listStreets list of specialstreets
     */
    public TrainingMap2(List<Cell> listRooms, List<Cell> listStreets) {
        super(widthOfTrainingMap, heightOfTrainingMap, listRooms, listStreets);
    }

    /**
     * Take an actor and move them on a specific cell according to Location
     * @param a the actor to move
     * @param l location of the cell the player is going to move
     */
    public void moveActor(Actor a, Location l){
        Cell current = a.getCell();
        int xCell = current.getPosition().getX();
        int yCell = current.getPosition().getY();

        Cell up = super.cells[xCell-1][yCell];
        Cell right = super.cells[xCell][yCell+1];
        Cell left = super.cells[xCell][yCell-1];
        Cell down = super.cells[xCell+1][yCell];

        switch (l){
            case NORTH:
                super.putActorONCell(a,up.getPosition());
                break;
            case SOUTH:
                super.putActorONCell(a,down.getPosition());
                break;
            case WEST:
                super.putActorONCell(a,left.getPosition());
                break;
            case EAST:
                super.putActorONCell(a,right.getPosition());
                break;
        }
    }
}
