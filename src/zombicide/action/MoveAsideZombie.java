package zombicide.action;

import zombicide.actor.zombie.Zombie;
import zombicide.callable.Callable;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

public class MoveAsideZombie extends AttackZombie{
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
        Location l = (Location)callable;
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
