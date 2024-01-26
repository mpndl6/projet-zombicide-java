package zombicide.map.util;

/**
* a position in a discrete 2D environment, a position is determined by integer
* coordinates x and y
*
*/
public class Position {

private int x;
private int y;

/**
* 
*creates a position corresponding to given coordinates
* 
* @param x the x coordinate
* @param y the y coordinate
*/
public Position(int x, int y) {
	this.x = x;
	this.y = y;
}
/**
 * @return the x coordinate
 */
public int getX() {
   return this.x;
}
/**
 * @return the y coordinate
 */
public int getY() {
   return this.y;
}

/**
 * two positions are equals if they have same coordinates
 * 
 */
public boolean equals(Object o) {
   if (o instanceof Position) {
      Position other = (Position) o;
      return this.x == other.x && this.y == other.y;
   } else {
      return false;
   }
}

/**
 * @return a string with the position of x and y 
 */
public String toString() {
   return this.x + " , " + this.y;
}
}
