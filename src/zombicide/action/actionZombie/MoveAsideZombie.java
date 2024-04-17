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
    protected Location whereToGo(){
        Cell cell = this.zombie.getCell();
        Position p = cell.getPosition();
        int xCell = p.getX();
        int yCell = p.getY();
        Map map = this.zombie.getGame().getMap();

        Cell noisier = map.NoisierCell();
        if(noisier.getPosition().getX()==xCell || noisier.getPosition().getX()==yCell) {
            if (xCell - noisier.getPosition().getX() > 0)
                return Location.NORTH;
            if (yCell - noisier.getPosition().getY()>0)
                return Location.WEST;
            else if (xCell - noisier.getPosition().getX()<0)
                return Location.SOUTH;
            else if (yCell - noisier.getPosition().getY()<0)
                return Location.EAST;
        }
        Random random = new Random();
        int dir =  random.nextInt(2);
        if (xCell - noisier.getPosition().getX() >0 & yCell - noisier.getPosition().getY()>0){
            switch (dir){
                case 0:
                    return Location.WEST;
                case 1:
                    return Location.NORTH;
            }
        }
        if (xCell - noisier.getPosition().getX() <0 & yCell - noisier.getPosition().getY()>0){
            switch (dir){
                case 0:
                    return Location.WEST;
                case 1:
                    return Location.SOUTH;
            }
        }
        if (xCell - noisier.getPosition().getX() >0 & yCell - noisier.getPosition().getY()<0){
            switch (dir){
                case 0:
                    return Location.EAST;
                case 1:
                    return Location.NORTH;
            }
        }
        if (xCell - noisier.getPosition().getX() <0 & yCell - noisier.getPosition().getY()<0){
            switch (dir){
                case 0:
                    return Location.EAST;
                case 1:
                    return Location.SOUTH;
            }
        }
        return whereToGo();
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

        if (!canMakeAction()) {
            System.out.println("Survivor is trying to go outside of the Map!");
            return false;
        }
        Location l = whereToGo();
        switch (l){
            case NORTH:
                if(!(map.isWall(cell,l) && map.isOpenDoor(cell,l))) {
                    map.putActorONCell(this.zombie,new Position(xCell-1, yCell));
                    return true;
                }
            case SOUTH:
                if(!(map.isWall(cell,l) && map.isOpenDoor(cell,l))) {
                    map.putActorONCell(this.zombie,new Position(xCell+1, yCell ));
                    return true;
                }
            case EAST:
                if(!(map.isWall(cell,l) && map.isOpenDoor(cell,l))) {
                    map.putActorONCell(this.zombie,new Position(xCell , yCell+1));
                    return true;
                }
            case WEST:
                if(!(map.isWall(cell,l) && map.isOpenDoor(cell,l))) {
                    map.putActorONCell(this.zombie,new Position(xCell , yCell -1));
                    return true;
                }
            default:
                System.out.println("le zombie ne peut pas bouger");
                return false;

        }
    }
}
