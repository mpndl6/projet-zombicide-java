package zombicide.map;

import java.util.*;

import zombicide.actor.Actor;
import zombicide.map.cell.*;
import zombicide.map.util.*;
import zombicide.map.cell.room.*;
import zombicide.map.cell.util.CellType;


public class Map {

    protected int width;
    protected int heigth;
    protected Position principalIntersection;
    protected Cell[][] cells;

    /**
     * It creates a Map with width and heigth
     * known at creation
     * the Map is initialised at creation
     *
     * @param w width of Map
     * @param h heigth of Map
     *          of Map
     */
    public Map(int w, int h) {
        this.width = w;
        this.heigth = h;
        this.cells = new Cell[w][h];

        for (w = 0; w < this.width; w++) {
            for (h = 0; h < this.heigth; h++) {
                this.cells[w][h] = new Room(new Position(w, h), this.width, this.heigth);
            }
        }

        this.principalIntersection = this.generatFirstRoad();
        this.putWasteWater();
        
        Position p = this.getPostionOfRoom(getListOfRooms());
        this.putSpecialRoom(new Continental(p,w,h),p);

        Position p2 = this.getPostionOfRoom(getListOfRooms());
        this.putSpecialRoom(new DrugStore(p2,w,h),p2);
    }
    /**
     * Places waste water objects at specified positions on the map.
     * Wastewater objects are placed at the edges of
     * the plan in relation to the main crossroads.
     */
    public void putWasteWater(){
        int x = principalIntersection.getX();
        int y = principalIntersection.getY();
        this.cells[x][0] = new StreetWW(new Position(x,0));
        this.cells[0][y] = new StreetWW(new Position(0,y));
        this.cells[x][this.heigth-1] = new StreetWW(new Position(x,this.heigth-1));
        this.cells[this.width-1][y] = new StreetWW(new Position(this.width-1,y));
    }

    /**
     * Tell is the wall at location c is a wall or not (a door)
     * @param c the cell we look at
     * @param l location where it's verified
     * @return true if the wall is a wall or false if it's a door
     */
    public boolean isWall(Cell c, Location l){
        int xCell = c.getPosition().getX();
        int yCell = c.getPosition().getY();

        switch (l){
            case NORTH:
                return xCell==0;
            case SOUTH:
                return xCell==this.width-1;
            case WEST:
                return yCell == 0;
            case EAST:
                return yCell == this.heigth-1;
        }
        return false;
    }

    /**
     * Open the neighbor door of the current Cell
     * @param current the cell we want to open the door
     * @param l Location of the door
     */
    public void openDoorOfRoom(Cell current ,Location l){
        int xCell = current.getPosition().getX();
        int yCell = current.getPosition().getY();

        Cell up = this.cells[xCell-1][yCell];
        Cell right = this.cells[xCell][yCell+1];
        Cell left = this.cells[xCell][yCell-1];
        Cell down = this.cells[xCell+1][yCell];
        ((Room)current).openDoor(l);
        switch (l){
            case NORTH:
                ((Room)up).openDoor(Location.SOUTH);
            case SOUTH:
                ((Room)down).openDoor(Location.NORTH);
            case WEST:
                ((Room)left).openDoor(Location.EAST);
            case EAST:
                ((Room)right).openDoor(Location.WEST);
        }
    }

    /**
     * @return heigth ofmap
     */
    public int getheigth() {
        return this.heigth;
    }

    /**
     * @return width ofmap
     */
    public int getWidth() {
        return this.heigth;
    }

    /**
     *
     */
    public Cell[][] getCells() {
        return this.cells;
    }


    /**
     * Generates a random number within a given range.
     *
     * @param max1 The maximum value.
     * @param min1 The minimum value.
     * @return A random number within the specified range.
     */
    public int generatNumberForInitmap(int max1, int min1) {
        int max = max1 - 2;
        int min = min1 + 2;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;
        return rand;
    }


    /**
     * Initializes the map with streets.
     *
     * @param wmax The maximum width.
     * @param wmin The minimum width.
     * @param hmax The maximum height.
     * @param hmin The minimum height.
     */
    public void initmap(int wmax, int wmin, int hmax, int hmin) {
        if (wmax - wmin >= 4 && hmax - hmin >= 4) {
            int wl = generatNumberForInitmap(wmax, wmin);
            int hl = generatNumberForInitmap(hmax, hmin);
            for (int j = hmin; j <= hmax; j++) {
                this.cells[wl][j] = new Street(new Position(wl, j));
            }
            for (int i = wmin; i <= wmax; i++) {
                this.cells[i][hl] = new Street(new Position(i, hl));
            }
            initmap(wmax, wl + 1, hl - 1, hmin);
            initmap(wmax, wl + 1, hmax, hl + 1);
            initmap(wl - 1, wmin, hl - 1, hmin);
            initmap(wl - 1, wmin, hmax, hl + 1);
        }

        if (wmax - wmin >= 4 && hmax - hmin < 4) {
            int wl = generatNumberForInitmap(wmax, wmin);
            for (int j = hmin; j <= hmax; j++) {
                this.cells[wl][j] = new Street(new Position(wl, j));
            }
            initmap(wmax, wl + 1, hmax, hmin);
            initmap(wl - 1, wmin, hmax, hmin);
        }

        if (wmax - wmin < 4 && hmax - hmin >= 4) {
            int hl = generatNumberForInitmap(hmax, hmin);
            for (int i = wmin; i <= wmax; i++) {
                this.cells[i][hl] = new Street(new Position(i, hl));
            }
            initmap(wmax, wmin, hl - 1, hmin);
            initmap(wmax, wmin, hmax, hl + 1);
        }
    }

    /**
     * Generates the first road on the map.
     *
     * @return The position of the main intersection.
     */
    public Position generatFirstRoad() {
        int wl = generatNumberForInitmap(this.width - 1, 0);
        int hl = generatNumberForInitmap(this.heigth - 1, 0);
        for (int j = 0; j <= this.heigth - 1; j++) {
            this.cells[wl][j] = new Street(new Position(wl, j));
        }
        for (int i = 0; i <= this.width - 1; i++) {
            this.cells[i][hl] = new Street(new Position(i, hl));
        }
        initmap(this.width - 1, wl + 1, hl - 1, 0);
        initmap(this.width - 1, wl + 1, this.heigth - 1, hl + 1);
        initmap(wl - 1, 0, hl - 1, 0);
        initmap(wl - 1, 0, this.heigth - 1, hl + 1);

        return new Position(wl, hl);
    }


    /**
     * Generates a random number for special room placement.
     *
     * @param m The maximum value.
     * @return A random number for special room placement.
     */
    public int generatNumberForSpecialRoom(int m) {
        int max = m;
        int min = 0;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;
        return rand;
    }

    /**
     * Retrieves a list of all rooms present in the grid.
     *
     * @return A list containing all the rooms found in the grid.
     */
    public List<Room> getListOfRooms() {
        List<Room> list = new ArrayList<Room>();
        for(int i = 0 ; i < this.width ; i++) {
            for(int j = 0 ; j < this.heigth ; j++){
                if(this.cells[i][j].getTypeOfCell() == CellType.ROOM)
                    list.add((Room) this.cells[i][j]);
            }

        }
        return list;
    }

    /**
     * Retrieves the position of a randomly selected room from the given list.
     *
     * @param l The list of rooms from which to select.
     * @return The position of a randomly chosen room.
     */
    public Position getPostionOfRoom(List<Room> l) {
        int n = generatNumberForSpecialRoom(l.size()-1);
        return l.get(n).getPosition();
    }

    /**
     * Places a special room at the specified position on the grid.
     *
     * @param r The special room to place.
     * @param p The position at which to place the special room.
     */
    public void putSpecialRoom(Room r,Position p) {
        this.cells[p.getX()][p.getY()] = r;
    }

    /**
     * put an actor on a specific cell
     * @param a the actor wanted
     * @param p the position wanted
     */
    public void putActorONCell(Actor a, Position p){
        int XCell = p.getX();
        int YCell = p.getY();
        this.cells[XCell][YCell].welcomeActor(a);
    }

}
