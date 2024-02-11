package zombicide.map.grid;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;
import zombicide.map.cell.Street;
import zombicide.map.util.Door;
import zombicide.map.util.Location;

import javax.management.remote.rmi.RMIConnectionImpl;
import java.util.Scanner;

public class Grid {
    protected Map map;

    private int weightOfCell; // the weight of cells
    public static final String separatorHWall = "█";
    public static final String separatorVWall = "-";
    public static final String separatorCloseVDoor = "|";
    public static final String separatorCloseHDoor = "-";
    public static final String separatorOpen = " ";

    /**
     * Its construct the grid of the map in param
     * @param m the map od the grid
     */
    //System.out.print(d.display1()+Grid.requireSpace(((Room)cell).toString()));
    public Grid(Map m,int weightOfCell ){
        this.map =m;
        this.weightOfCell = weightOfCell;


    }

    /**
     * display s + padding
     * @param s the string we want to add the padding
     */
    public void padding(String s){
        int givenLength = s.length();
        if (givenLength >= this.weightOfCell )
            System.out.print(s);
        else{
            int missingSpace = this.weightOfCell - givenLength;
            System.out.print(s+" ".repeat(missingSpace));
        }
    }


    /**
     * @return true if the cell is a room
     * @param c the cell
     */
    public boolean isRoom(Cell c){
        return c instanceof Room;
    }

    /**
     * the cell right to c
     * @param c the cell
     */
    public Cell cellToRight(Cell c){
        Cell[][] cellsOfMap = this.map.getCells();
        int xCell = c.getPosition().getX();
        int yCell = c.getPosition().getY();

        return cellsOfMap[xCell][yCell+1];
    }

    /**
     * the cell left to c
     * @param c the cell
     */
    public Cell cellToLeft(Cell c){
        Cell[][] cellsOfMap = this.map.getCells();
        int xCell = c.getPosition().getX();
        int yCell = c.getPosition().getY();

        return cellsOfMap[xCell][yCell-1];
    }

    /**
     * the cell bollow c
     * @param c the cell
     */
    public Cell cellBellow(Cell c){
        Cell[][] cellsOfMap = this.map.getCells();
        int xCell = c.getPosition().getX();
        int yCell = c.getPosition().getY();

        return cellsOfMap[xCell+1][yCell];
    }

    /**
     * the cell up c
     * @param c the cell
     */
    public Cell cellAbove(Cell c){
        Cell[][] cellsOfMap = this.map.getCells();
        int xCell = c.getPosition().getX();
        int yCell = c.getPosition().getY();

        return cellsOfMap[xCell-1][yCell];
    }

    /**
     *
     */
    public boolean isWall(Cell c, Location l){
        Cell[][] cellsOfMap = this.map.getCells();
        int xCell = c.getPosition().getX();
        int yCell = c.getPosition().getY();

        switch (l){
            case NORTH:
                return xCell==0;
            case SOUTH:
                return xCell==cellsOfMap.length-1;
            case WEST:
                return yCell == 0;
            case EAST:
                return yCell == cellsOfMap[0].length-1;
        }
        return false;
    }

    /**
     * Display the first line on the board
     * @param cell the current cell on board
     */
    public void displayFisrtLine(Cell cell){
        Cell[][] cellsOfMap = this.map.getCells();

        if (isWall(cell, Location.NORTH))
            System.out.print(separatorVWall.repeat(this.weightOfCell));

        else{
            if (isRoom(cell)){
                if (((Room)cell).isOpen(Location.NORTH))
                    System.out.print(separatorOpen.repeat(this.weightOfCell));

                else
                    System.out.print(separatorCloseHDoor.repeat(this.weightOfCell));
            }

            else{
                Cell upCell = cellAbove(cell);
                if (isRoom(upCell)){
                    if (((Room)upCell).isOpen(Location.SOUTH))
                        System.out.print(separatorOpen.repeat(this.weightOfCell));
                    else
                        System.out.print(separatorCloseHDoor.repeat(this.weightOfCell));
                }
                else
                    System.out.print(separatorOpen.repeat(this.weightOfCell));

            }
        }

    }

    /**
     *
     * @param cell
     */
    public void displaySecondLine(Cell cell){

        if (isWall(cell, Location.WEST))
            padding(separatorHWall+cell);

        else {
                if (isRoom(cell)) {
                    if (((Room) cell).isOpen(Location.WEST))
                        padding(separatorOpen+cell);

                    else
                        padding(separatorCloseVDoor+cell);
                }
                else {
                    Cell leftCell = cellToLeft(cell);
                    if (isRoom(leftCell)) {
                        if (((Room) leftCell).isOpen(Location.EAST))
                            padding(separatorOpen+cell);
                        else
                            padding(separatorCloseVDoor+cell);
                    }
                    else
                        padding(separatorOpen+cell);

                }
            }
        if (isWall(cell, Location.EAST))
            System.out.print(separatorHWall);


        }

        public void displayLastWall(){
        Cell[][] cellsOfMap = this.map.getCells();
        System.out.print(separatorVWall.repeat(this.weightOfCell*cellsOfMap[0].length));
        }

    /**
     *
     * @param cell
     */
    public void displayThirdLine(Cell cell){

        if (isWall(cell, Location.WEST))
            padding(separatorHWall);

        else {
            if (isRoom(cell)) {
                if (((Room) cell).isOpen(Location.WEST))
                    padding(separatorOpen);

                else
                    padding(separatorCloseVDoor);
            }
            else {
                Cell leftCell = cellToLeft(cell);
                if (isRoom(leftCell)) {
                    if (((Room) leftCell).isOpen(Location.EAST))
                        padding(separatorOpen);
                    else
                        padding(separatorCloseVDoor);
                }
                else
                    padding(separatorOpen+cell);

            }
        }
        if (isWall(cell, Location.EAST))
            System.out.print(separatorHWall);

    }

    /**
     *
     */
    public void displayGrid(){
        Cell[][] cellsOfMap = this.map.getCells();
        for (int y=0; y<cellsOfMap.length;y++){
            for (int y_d=0; y_d<3; y_d++) {
                for (int x = 0; x < cellsOfMap[0].length; x++) {
                    Cell cell = cellsOfMap[y][x];
                    if (y_d == 0)
                        displayFisrtLine(cell);
                    if (y_d == 1)
                        displaySecondLine(cell);

                    if (y_d==2)
                        displayThirdLine(cell);
                }
                System.out.println();
            }
        }
        displayLastWall();

    }


}


