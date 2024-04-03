package grid;

import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;
import zombicide.map.cell.room.Continental;
import zombicide.map.util.Location;

/**
 * Grid for the display of a plan
 */
public class GridOfPlan extends Grid{
    protected Map map;
    protected static final int WOFC = 5;
    protected static final String CONTINENTAL_COVERUP = "R"; // Continental will be faking a room to be impossible to find.
    public GridOfPlan(Map map){
        super(map,WOFC);
    }

    /**
     *
     */
    /**
     * Display the separators between this cell and its environment
     * @param cell the current cell
     */
    public void displaySecondLine(Cell cell){

        if (super.map.isWall(cell, Location.WEST))
            padding(separatorHWall+cell);
        else {
            if (super.isRoom(cell)) {
                if (((Room) cell).isOpen(Location.WEST)) {
                    if(cell instanceof Continental)
                        padding(separatorOpen + CONTINENTAL_COVERUP);
                    else{
                    padding(separatorOpen + cell);}
                }
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
        if (map.isWall(cell, Location.EAST))
            System.out.print(separatorHWall);
    }

}
