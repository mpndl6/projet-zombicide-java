package zombicide.map;

import exception.IsWallException;
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
    public void moveActor(Actor a, Location l) throws IsWallException {
        Cell current = a.getCell();
        int xCell = current.getPosition().getX();
        int yCell = current.getPosition().getY();
        if(isWall(a.getCell(),l)){
            throw new IsWallException();
        }

        switch (l){
            case NORTH:
                Cell up = super.cells[xCell-1][yCell];
                super.putActorONCell(a,up.getPosition());
                break;
            case SOUTH:
                Cell down = super.cells[xCell+1][yCell];
                super.putActorONCell(a,down.getPosition());
                break;
            case WEST:
                Cell left = super.cells[xCell][yCell-1];
                super.putActorONCell(a,left.getPosition());
                break;
            case EAST:
                Cell right = super.cells[xCell][yCell+1];
                super.putActorONCell(a,right.getPosition());
                break;
        }
    }
}
