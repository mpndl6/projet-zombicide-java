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
     * @param listRooms list of specialrooms
     * @param listStreets list of specialstreets
     */
    public Map(int w, int h, List<Cell> listRooms, List<Cell> listStreets) {
        this.width = w;
        this.heigth = h;
        this.cells = new Cell[w][h];

        for (w = 0; w < this.width; w++) {
            for (h = 0; h < this.heigth; h++) {
                this.cells[w][h] = new Room();
            }
        }

        this.principalIntersection = this.generatFirstRoad();
        this.putWasteWater();
        this.putPositionOfCells();

        List<Cell> listCell = this.getListOfCells(CellType.ROOM);
        List<Position> listPos = this.getPostionsForSpecialCells(listRooms.size(),listCell);
        this.putSpecialCells(listRooms,listPos);

        List<Cell> listCell2 = this.getListOfCells(CellType.STREET);
        List<Position> listPos2 = this.getPostionsForSpecialCells(listStreets.size(),listCell2);
        this.putSpecialCells(listStreets,listPos2);

    }
    /**
     * Places waste water objects at specified positions on the map.
     * Wastewater objects are placed at the edges of
     * the plan in relation to the main crossroads.
     */
    public void putWasteWater(){
        int x = principalIntersection.getX();
        int y = principalIntersection.getY();
        this.cells[x][0] = new StreetWW();
        this.cells[0][y] = new StreetWW();
        this.cells[x][this.heigth-1] = new StreetWW();
        this.cells[this.width-1][y] = new StreetWW();
    }

    /**
     * Permits to get the position of the wastewater in west, east, north or south
     * @param l the specific location
     * @return the position of the wastewater at location l
     */
    public Position getPositionOFWaster(Location l){
        int x = principalIntersection.getX();
        int y = principalIntersection.getY();
        switch (l){
            case WEST:
                return this.cells[x][0].getPosition();
            case EAST:
                return this.cells[0][y].getPosition();
            case NORTH:
                return this.cells[x][this.heigth-1].getPosition();
            case SOUTH:
                return  this.cells[this.width-1][y].getPosition();

        }
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

        if (current instanceof Room)
            ((Room) current).openDoor(l);

            switch (l) {
                case NORTH:
                    if (up instanceof Room)
                    ((Room) up).openDoor(Location.SOUTH);
                case SOUTH:
                    if(down instanceof Room)
                    ((Room) down).openDoor(Location.NORTH);
                case WEST:
                    if (left instanceof Room)
                    ((Room) left).openDoor(Location.EAST);
                case EAST:
                    if (right instanceof Room)
                    ((Room) right).openDoor(Location.WEST);
            }
    }

    /**
     * @return heigth ofmap
     */
    public int getHeight() {
        return this.heigth;
    }

    /**
     * @return width ofmap
     */
    public int getWidth() {
        return this.heigth;
    }

    /**
     * @return the cells of the map
     */
    public Cell[][] getCells() {
        return this.cells;
    }

    /**
     * @return a specific cell
     * @param p the position of the wanted cell
     */
    public Cell getCell(Position p){
        return this.cells[p.getX()][p.getY()];
    }

    /**
     * @return the position of the principal intersection
     */
    public Position getPrincipalIntersection() {
        return principalIntersection;
    }

    /**
     * Generates a random number within a given range.
     *
     * @param max1 The maximum value.
     * @param min1 The minimum value.
     * @return A random number within the specified range.
     */
    public int generateNumberForInitmap(int max1, int min1) {
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
            int wl = generateNumberForInitmap(wmax, wmin);
            int hl = generateNumberForInitmap(hmax, hmin);
            for (int j = hmin; j <= hmax; j++) {
                this.cells[wl][j] = new Street();
            }
            for (int i = wmin; i <= wmax; i++) {
                this.cells[i][hl] = new Street();
            }
            initmap(wmax, wl + 1, hl - 1, hmin);
            initmap(wmax, wl + 1, hmax, hl + 1);
            initmap(wl - 1, wmin, hl - 1, hmin);
            initmap(wl - 1, wmin, hmax, hl + 1);
        }

        if (wmax - wmin >= 4 && hmax - hmin < 4) {
            int wl = generateNumberForInitmap(wmax, wmin);
            for (int j = hmin; j <= hmax; j++) {
                this.cells[wl][j] = new Street();
            }
            initmap(wmax, wl + 1, hmax, hmin);
            initmap(wl - 1, wmin, hmax, hmin);
        }

        if (wmax - wmin < 4 && hmax - hmin >= 4) {
            int hl = generateNumberForInitmap(hmax, hmin);
            for (int i = wmin; i <= wmax; i++) {
                this.cells[i][hl] = new Street();
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
        int wl = generateNumberForInitmap(this.width - 1, 0);
        int hl = generateNumberForInitmap(this.heigth - 1, 0);
        for (int j = 0; j <= this.heigth - 1; j++) {
            this.cells[wl][j] = new Street();
        }
        for (int i = 0; i <= this.width - 1; i++) {
            this.cells[i][hl] = new Street();
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
     * Retrieves a list of all cells of a given type present in the map.
     *
     * @param t The type of cells to retrieve.
     * @return A list containing all the cells of the specified type found in the map.
     */
    public List<Cell> getListOfCells(CellType t) {
        List<Cell> list = new ArrayList<Cell>();
        for(int i = 0 ; i < this.width ; i++) {
            for(int j = 0 ; j < this.heigth ; j++){
                if(this.cells[i][j].getTypeOfCell() == t)
                    list.add(this.cells[i][j]);
            }

        }
        return list;
    }

    /**
     * Retrieves the positions of randomly selected cells from the given list.
     *
     * @param n The number of positions to retrieve.
     * @param l The list of cells from which to select.
     * @return The positions of randomly chosen cells.
     */
    public List<Position> getPostionsForSpecialCells(int n , List<Cell> l) {
        Iterator<Cell> cellIterator = l.iterator();
        List<Position> list = new ArrayList<Position>();
        for(int  i = n ; i > 0 ; i--) {
            if(cellIterator.hasNext()) {
                int j = generatNumberForSpecialRoom(l.size() - 1);
                list.add(l.get(j).getPosition());
                l.remove(j);
            } else {
                break;
            }
        }
        return list;
    }

    /**
     * Places special cells at specified positions on the map.
     *
     * @param listCell The list of special cells to place.
     * @param listPos  The positions where the special cells will be placed.
     */
    public void putSpecialCells(List<Cell> listCell ,List<Position> listPos) {
        Iterator<Cell> cellIterator = listCell.iterator();
        for(Position p: listPos) {
            if (cellIterator.hasNext()) {
                listCell.get(0).putPosition(p);
                this.cells[p.getX()][p.getY()] = listCell.get(0);
                listCell.remove(0);
            } else {
                break;
            }
        }
    }

    /**
     * Places positions on all cells of the map.
     */
    public void putPositionOfCells() {
        for(int  i = 0 ; i < this.width ; i++) {
            for(int j = 0 ; j < this.heigth ; j++) {
                this.cells[i][j].putPosition(new Position(i,j));
            }
        }
    }

    /**
     * put an actor on a specific cell
     * @param a the actor wanted
     * @param p the position wanted
     */
    public void putActorONCell(Actor a, Position p){
        int XCell = p.getX();
        int YCell = p.getY();
        if (a.getCell()!=null)
            a.getCell().removeActor(a);
        this.cells[XCell][YCell].welcomeActor(a);
        a.setCell(this.cells[XCell][YCell]);

    }

}
