package zombicide.actor.survivors;
import zombicide.actor.Actor;
import zombicide.item.*;
import java.util.*;
import zombicide.item.weapons.*;

/**
 * class of survivors
 */
public class Survivor extends Actor {

/**
 * All three level a survivor can reach
  */
protected static final int THIRD_LEVEL = 3;
protected static final int ELEVENTH_LEVEL = 11;
protected static final int SEVENTH_LEVEL = 7;
protected static final int STARTING_LEVEL =0;
protected static final int MAX_NB_ITEM = 5;
protected int currentLevel;
protected String nickName; // nick
protected int lifePoint; // life points of the survivor
protected int XP; // level of expertise of a survivor
protected Item inHand; // the item the survivor has in hand
protected List<Item> backPack;
// protected List<Role> roles;
protected int actionPoint;

/**
 *  Contruct a survivor with their name in parameter.
 *  At creation, a survivor has a Pistol in hand
 * 5 life points, 0 XP, 0 action points et nothing in backpack
 * @param name the nickname of the survivor
 *
 */
public Survivor( String name){
    this.nickName = name;
    this.currentLevel = STARTING_LEVEL;
    this.XP = 0;
    this.actionPoint = 0;
    this.backPack = new ArrayList<>();
    this.inHand = new Pistol();
}

/**
 * Returns  level of expertise of a survivor
 * @return XP of survivor
 */
public int getXP(){
return this.XP;
}

/**
 * Returns the current level of the survivor
 * @return the current level of Survivor
 */
public int getCurrentLevel(){
    return this.currentLevel;
}

/**
 * @return the nickname of the survivor
 */
public String getNickeName(){
    return this.nickName;
}

/**
 * @return number of action points of survivor
 */
public int getActionPoint(){
    return this.actionPoint;
}

/**
 * Returns what item the survivor has in hand
 * @return the item the survivor has in hand
 */
public Item getWhatINHand(){
    return this.inHand;
}

/**
 * Return all of the item present in the backpack
 * @return all of the item in backpack
 */
public List<Item> getAllInBackpack(){
    return this.backPack;
}

/**
 * Get a precise Item in the backpack
 * @param i the item wanted
 * @return the Itam i if it's in backpack
 * @throws NoSuchItemException if the Item it's not in the backpack
 */
/*public Item getItem(Item i) throws NoSuchItemException {
//TODO si c'est pertinent
}*/

/**
 * Increase the current level of the survivor
 */
public void increaseLevel(){
    this.currentLevel ++;
}

/**
 * increase life points of survivor
 */
public void increaseLifePoint(){
    this.lifePoint++;
}

/**
 * increase action points of survivor
 */
public void increaseActionPoint(){
    this.actionPoint++;
}

/**
 * Increase XP of survivor
 */
public void increaseXP(){
    this.XP++;
}

/**
 * Tells if the survivor has an item on their hand
 * @return true if survivor has an item on hand
 */
public boolean hasItemOnHand(){
return this.inHand!=null;
}

/**
 * Put  the item i in the hand of the survivor
 * @param i the wanted item to put in hand
 */
public void putInHand(Item i){
    if(hasItemOnHand())
        putItemInBackpack(this.inHand);
    this.inHand = i;
}

/**
 * It puts an item on cell
 * @param i the item we throw on cell
 */
public void putItemOnCell(Item i){
super.cell.addItem(i);
}

/**
 * Put the item i in Backpack. If the number of item in backpack has reach 5, the oldest item added of the list will be
 * remove and replace by the wanted item.
 * If it's a street it will disapear and if it's a room it will be added to the list of item of the room
 * @param i the item wanted in backpack
 */
public void putItemInBackpack(Item i){
    if (this.backPack.size()==MAX_NB_ITEM){
        Item oldestItem = this.backPack.get(0); // the oldest item added
        this.backPack.remove(oldestItem);
        this.putItemOnCell(oldestItem);
    }
    this.backPack.add(i);
}


}
