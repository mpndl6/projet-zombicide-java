package zombicide;

import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.map.Map;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import java.util.*;

/**
 *
 */
public class Game {
    protected Map map;
    protected List<Survivor> listSurvivors;
    protected List<Zombie> listZombies;

    /**
     *
     * @param map
     */
    public Game(Map map) {
        this.map = map;
        this.listSurvivors = new ArrayList<>();
        this.listZombies = new ArrayList<>();
    }

    /**
     *
     * @param p1
     * @param p2
     * @return
     */
    public boolean doorsBetween(Position p1, Position p2) {
        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();
        boolean res = true;
        if (x1 == x2 || y1 == y2){
            if (x1 > x2) {
                for (int i = x1; i > x2 ; i--) {
                    res = res && this.map.isOpenDoor(this.map.getCell(new Position(i,y1)), Location.WEST);

                }
            }
            if (x1 < x2) {
                for (int i = x1; i < x2 ; i++) {
                    res = res && this.map.isOpenDoor(this.map.getCell(new Position(i,y1)), Location.EAST);

                }
            }
            if (y1 > y2) {
                for (int i = y1; i > y2 ; i--) {
                    res = res && this.map.isOpenDoor(this.map.getCell(new Position(x1,i)), Location.NORTH);

                }
            }
            if (y1 < y2) {
                for (int i = y1; i < y2 ; i++) {
                    res = res && this.map.isOpenDoor(this.map.getCell(new Position(x1,i)), Location.SOUTH);

                }
            }
        }
        return res;
    }
}
