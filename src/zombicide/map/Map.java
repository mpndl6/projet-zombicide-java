package zombicide.map;

/** class of the board of the game */
public class Map {


protected int heitgh; // heitgh  of Map
protected int width; // witdh of map

/** Construct a map 
 * The heeitgh and width are known at creation
 */
public Map(int w, int h){
    this.heitgh = h;
    this.width = w;
    initMap();
}



}
