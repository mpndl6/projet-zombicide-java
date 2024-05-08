package zombicide.action.actionZombie;

import zombicide.action.MoveAside;
import zombicide.actor.zombie.Zombie;
import zombicide.callable.Callable;
import zombicide.map.cell.Cell;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import java.util.Random;

/**
 * Class MoveAside for the zombies
 */
public class MoveAsideZombie extends MoveAside {
    /**
     * Construct a action move aside Zombie
     * Permits to a zombie to move
     * @param z the zombie linked to this action
     */
    public MoveAsideZombie(Zombie z) {
        super(z);
    }

    /**
     * Indicate to the zombie the area with the most level of noise
     * @return the location for the zombie to go
     */
    protected Location whereToGo(Cell cellToReach){ // mettre une cell en attribut
        Cell cell = this.actor.getCell();
        Position p = cell.getPosition();
        int xCell = p.getX();
        int yCell = p.getY();

        if(cellToReach.getPosition().getX()==xCell && cellToReach.getPosition().getY()==yCell)
            return null; // s'ils sont sur la même cell on arrête

        if(cellToReach.getPosition().getX()==xCell) {
            if (yCell - cellToReach.getPosition().getY()>0)
                return Location.WEST;
            else if (yCell - cellToReach.getPosition().getY()<0)
                return Location.EAST;
        }

        else if (cellToReach.getPosition().getY()==yCell){
            if (xCell - cellToReach.getPosition().getX() > 0)
                return Location.NORTH;
            else if (xCell - cellToReach.getPosition().getX()<0)
                return Location.SOUTH;
        }
        else {
            Random random = new Random();
            int dir = random.nextInt(2);
            if (xCell - cellToReach.getPosition().getX() > 0 & yCell - cellToReach.getPosition().getY() > 0) {
                switch (dir) {
                    case 0:
                        return Location.WEST;
                    case 1:
                        return Location.NORTH;

                }
            }
            if (xCell - cellToReach.getPosition().getX() < 0 & yCell - cellToReach.getPosition().getY() > 0) {
                switch (dir) {
                    case 0:
                        return Location.WEST;
                    case 1:
                        return Location.SOUTH;
                }
            }
            if (xCell - cellToReach.getPosition().getX() > 0 & yCell - cellToReach.getPosition().getY() < 0) {
                switch (dir) {
                    case 0:
                        return Location.EAST;
                    case 1:
                        return Location.NORTH;
                }
            }
            if (xCell - cellToReach.getPosition().getX() < 0 & yCell - cellToReach.getPosition().getY() < 0) {
                switch (dir) {
                    case 0:
                        return Location.EAST;
                    case 1:
                        return Location.SOUTH;
                }
            }
        }
        return null;
    }

    /**
     * This methode moves the zombie to a specific cell.
     * zombies have cell and those cell can have different positions.
     * @param callable a callable, here it's an instance of Cell
     * @return true if the zombie has moved eventually
     */
    @Override
    public boolean make(Callable callable){
        Cell cellToReach = (Cell)callable;
        Location l = whereToGo(cellToReach);
        if (whereToGo(cellToReach)==null) {
            return false;
        }
        return super.make(l);
    }
}
