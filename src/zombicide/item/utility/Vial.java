package zombicide.item.utility;

/**
* Represents a vial utility item.
* Vials can be used to increase the life points of the survivor.
*/
public class Vial extends Utility {

/**
 * Constructs a new Vial utility item.
 */
public Vial(){

}

/**
 * Uses the vial utility item to increase the life points of the survivor.
 * This method overrides the use method from the Utility class.
 */
@Override
public void use() {
    this.survivor.increaseLifePoints();
    System.out.println("Your life points just increased.\n You have "+super.survivor.getLifePoints()+" lp.");
}

/**
 * Returns a string representation of the vial item.
 * @return a description of the item
 */
@Override
public String toString(){
    return "Vial";
}
}
