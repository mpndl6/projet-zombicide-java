package zombicide.map.cell;
import zombicide.util.Position;

/** the street cell in the map */
public class Street {

/** streets have or not a wastewater on where the zombies go out*/
private boolan wastewater;

/** Construct a street
 * We can set a wastewater or not on the cell
 */
public Street(Position p, boolean hasWastewater){
    super(p);
    this.wastewater =hasWastewater;
}





}
