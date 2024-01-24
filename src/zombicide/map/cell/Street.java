package zombicide.map.cell;
import zombicide.util.Position;

/** the street cell in the map */
public class Street {

/** streets have or not a wastewater on where the zombies go out*/
private boolan wastewater;

/** Construct a street
 * We can set a wastewater or not on the cell
 * @param p the position of the cell street
 * @param hasWastewater is true when the street constains a wastewater
 */
public Street(Position p, boolean hasWastewater){
    super(p);
    this.wastewater=hasWastewater;
}

/**
 * @return true if the cell street constains a wastewater
 */
public boolean hasWastewater(){
    return this.wastewater;
}






}
