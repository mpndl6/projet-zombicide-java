package zombicide.map.util;
import zombicide.callable.Callable;

import java.util.Random;

/**
* The Location enum represents cardinal directions.
*/
public enum Location implements Callable {
	   EAST,NORTH,WEST,SOUTH;
	private static Random ALEA = new Random();

	/**
	 * Permits to retrieve a random location
	 * @return a random Location [NORTH, SOUTH, EAST, WEST]
	 */
	public static Location randomLocation(){
		return Location.values() [ ALEA.nextInt(Location.values().length) ];
	}
}
