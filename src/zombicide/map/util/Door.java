package zombicide.map.util;
/**
 * The Door class represents a door with a specific location and provides functionality
 * to check if it's open, open the door, and retrieve its location.
*/
public class Door {
	protected boolean open;
	protected Location location;
	
/**
* Constructs a new Door object with the specified location.
* The door is initially closed.
*
* @param l The location of the door.
*/
public Door(Location l) {
	this.location=l;
	this.open=false;
}
	
/**
* Checks if the door is currently open.
*
* @return true if the door is open, false otherwise.
*/
public boolean isOpen() {
	return open;
   }

/**
* Opens the door, changing its state to open.
*/
public void open() {
	open = true;
}

/**
* Retrieves the location of the door.
*
* @return The location of the door.
*/
public Location getLocation() {
	return location;
}
}


