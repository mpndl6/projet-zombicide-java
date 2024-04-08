package zombicide.map.cell;

import java.util.ArrayList;
import java.util.List;

//import zombicide.map.grid.element.ElementGrid;
import zombicide.actor.Actor;
import zombicide.actor.ActorType;
import zombicide.callable.Callable;
import zombicide.item.Item;
import zombicide.map.util.*;

public abstract class Cell implements Callable {
	
//List to store survivors and zombies in the cell
protected List<Actor> actors;
protected List<Item> items;
// The noise level and position and the type of the cell
protected int noiseLevel;
protected Position position;


/***
 * Construct a new Cell
 * At creation a Cell has 0 noise level
 */
public Cell() {

	this.noiseLevel=0;
	this.position=null;
	this.actors=new ArrayList<Actor>();
	this.items = new ArrayList<>();
}

  /**
 * Adds an actor to the cell
 *@param a to be added to the cell
 */
public void welcomeActor(Actor a){
	this.actors.add(a);
}

/**
 *  Removes an actor from the cell
 *@param a to be removed from the cell
 */
public void removeActor(Actor a) {
	this.actors.remove(a);
}


/**
 * Gets the numbers of actors on the cell
 * @return how many actors there are on cell
 */
public int howManyActors() {
	return this.actors.size();
}

/**
 * Get the numbers of survivors on the cell
 * @return nb of survivors on cell
 */
public int howManySurvivors() {
	int i = 0;
	for(Actor a : this.actors) {
		if(a.getTypeOfActor() == ActorType.SURVIVOR)
			i++;
	}
	return i;
}

/**
 * Gets the numbers of survivors on the cell
 * @return nb of zombies on cell
 */
public int howManyZombies() {
	int i = 0;
	for(Actor a : this.actors) {
		if(a.getTypeOfActor() == ActorType.ZOMBIE)
			i++;
	}
	return i;
}

/*
 *  Gets the count of zombies in the cell
 *@return The number of zombies in the cell

public int howManyZombies() {
	return this.zombies.size();
}*/
 /**
 *Gets the list of actors in the cell
 *@return List of actors in the cell
 */
public List<Actor> getActors(){
	return this.actors;
}

/**
 *
 *  Gets the noise level in the cell
 * @return The noise level of the cell
 */
public int getNoiseLevel() {
	return this.noiseLevel;
}

/**
 *
 *  increase the noise level in the cell
 *
 * */
public void makenoise(){ this.noiseLevel++;}
/**
 * Adds an item to the room.
 * @param i The item to be added.
 */
public abstract void addItem(Item i);

/**
 * Removes an item from the cell.
 * @param i The item to be removed.
 */
public abstract void removeItem(Item i);

/**
 * Gets the numbers of item on cell
 * @return the nb items present on cell
 */
public int getNbItems(){
	return items.size();
}

/**
 * Retrieves the items present in the room.
 * @return The list of items present in the room.
 */
public List<Item>getItems(){
	return this.items;
}

/**
 * Tells if the item in parameter is on cell
 * @param i the item wanted
 * @return true if the item i is on cell
 */
public boolean containsItem(Item i){
	return items.contains(i);
}

/**
 * Returns the number of items in the room.
 * @return The number of items.
 */
public int getNbItem() {
	return this.items.size();
}

/**
 *
 * Checks if actors can fight in this area
 * @return true if there are survivors who can fight, false otherwise
 */
public abstract boolean canFight();

/**
 * Provides a precise description of the cell necessary for display
 * @return a description of the cell
 */
public abstract String toString();

/**
 *
 * Gets the position of the cell
* @return The position of the cell
*/
public Position getPosition() {
	return this.position;
}

/**
 * Returns the type of the cell
 *
 * @return the type of the cell
 */
public abstract Object getTypeOfCell();

/**
 * Set a position to the current Cell
 * @param p the position wanted
 */
public void setPosition(Position p){
	this.position = p;
}

/**
 * put the position of the cell
 * @param p position of cell
 */
public void putPosition(Position p) {
	this.position = p;
}

/**
 * Indicates whether some other object is "equal to" this one.
 * Two cells are considered equal if they have the same position.
 *
 * @param o the reference object with which to compare.
 * @return true if this cell is the same as the object argument; false otherwise.
 */

public boolean equals(Object o) {
	if(!(o instanceof Cell)) {
		return false;
	}
	Cell other = (Cell) o;
	return this.position.equals(other.position);
}

/**
 * Provides a description of the cell
 * @return description of cell
 */
public abstract String description();

}

