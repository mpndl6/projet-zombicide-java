package zombicide.action.actionZombie;

import zombicide.action.actionZombie.AttackZombie;
import zombicide.actor.zombie.Zombie;
import zombicide.callable.Callable;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import java.util.Random;

public class MoveAsideZombie extends AttackZombie {
    /**
     * @param z
     */
    public MoveAsideZombie(Zombie z) {
        super(z);
    }
    /**
     * This methode tells if the zombie can do this action.
     * It always returns true basically
     * @return true, always
     */
    @Override
    public boolean canMakeAction() {
        return true;
    }

    /**
     * Indicate to the zombie the area with the most level of noise
     * @return the location for the zombie to go
     */
    protected Location whereToGo(Cell cellToReach){ // mettre une cell en attribut
        Cell cell = this.zombie.getCell();
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
     * @param callable a callable, here it's an instance of Location
     * @return true if the zombie has moved eventually
     */
    @Override
    public boolean make(Callable callable){
        Cell cell = this.zombie.getCell();
        Position p = cell.getPosition();
        int xCell = p.getX();
        int yCell = p.getY();
        Map map = this.zombie.getGame().getMap();
        Cell cellToReach = (Cell)callable;
        Location l = whereToGo(cellToReach);

        if (!canMakeAction() || whereToGo(cellToReach)==null || map.isWall(cell,l) || !map.isOpenDoor(cell,l)) {
            return false;
        }
        switch (l) {
            case NORTH:
                map.putActorONCell(this.zombie, new Position(xCell - 1, yCell));
                System.out.println("up");
                return true;
            case SOUTH:
                map.putActorONCell(this.zombie, new Position(xCell + 1, yCell));
                System.out.println("down");
                return true;
            case EAST:
                map.putActorONCell(this.zombie, new Position(xCell, yCell + 1));
                System.out.println("east");
                return true;
            case WEST:
                map.putActorONCell(this.zombie, new Position(xCell, yCell - 1));
                System.out.println("west");
                return true;

            default:
                System.out.println("le zombie ne peut pas bouger");
                return false;

        }
    }
}
