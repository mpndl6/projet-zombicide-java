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




}
