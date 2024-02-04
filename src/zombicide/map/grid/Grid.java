package zombicide.map.grid;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;
import zombicide.map.cell.Street;
import zombicide.map.util.Door;

public class Grid {
    protected Map map;

    public static final int REQUIRE_SPACE=5; // for the cell to always have the same weigh

    /**
     * Its construct the grid of the map in param
     * @param m the map od the grid
     */
    //System.out.print(d.display1()+Grid.requireSpace(((Room)cell).toString()));
    public Grid(Map m){
        this.map =m;
    }

    public static String requireSpace(String s){
        if (s.length() ==REQUIRE_SPACE )
            return s;
        else{
        int missingSpace = REQUIRE_SPACE - s.length();
        return s+" ".repeat(missingSpace);
    }
    }

    public void displayGrid() {
        Door d = new Door();
        int rows = map.getWidth();
        int columns = map.getheigth();
        Cell[][] cellsOfMap = map.getCells();
        for (int col = 0; col < columns; col++) {
            System.out.print("+-----");
        }
        System.out.println("+");


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Cell cell = cellsOfMap[row][col];
                if (cell instanceof Room){
                System.out.print("|R    ");
                }
                else if (cell instanceof Street){
                    if (col > 0){
                        Cell leftCell = cellsOfMap[row][columns - 1];
                        if (leftCell instanceof Room)
                        System.out.print("|   . ");
                        else
                            System.out.print("  .   ");
                    }
                }
                else {
                    System.out.print("      ");
                }
            }
            System.out.println("");

            for (int col = 0; col < columns; col++) {
                Cell cell = cellsOfMap[row][col];
                if(cell instanceof Room){
                    System.out.print("+-----");
                }
                else if (cell instanceof Street){
                    if (row < rows-1){
                        Cell downCell = cellsOfMap[row + 1][col];
                        if (downCell instanceof Room){
                        System.out.print("+-----");}
                        else{
                            System.out.print("      ");
                        }
                    }

                }
                else{
                    System.out.print("      ");
                }
            }
            System.out.println(" ");
        }


            }




    public static void main(String [] args){
      Map map = new Map(10,10);
      Grid grid= new Grid(map);
        grid.displayGrid();

    }
            }








