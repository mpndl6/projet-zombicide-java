package zombicide.actor.survivors;
import zombicide.actor.Actor;
import zombicide.actor.ActorType;
import zombicide.item.*;
import java.util.*;
import zombicide.item.weapon.*;
import zombicide.map.cell.Cell;

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
protected static final int STARTING_LEVEL =0; // at begenning a survivor is at level 0
protected static final int MAX_NB_ITEM = 5; // in backpack
protected SurvivorsLevel currentLevel; // the level the survivor is currently in
protected String nickName; // nickname of survivor
protected int XP; // level of expertise of a survivor
protected Item inHand; // the item the survivor has in hand
protected List<Item> backPack;
// protected List<Role> roles;
protected int actionPoint;
    protected ActorType typeOfActor;


    private static Random randomNB = new Random( ) ;

    /**
     *  Contruct a survivor with their name in parameter.
     *  At creation, a survivor has a Pistol in hand
     * 5 life points, 0 XP, 0 action points et nothing in backpack
     * @param name the nickname of the survivor
     *
     */
    public Survivor(String name){
        super(name, 5);
        this.typeOfActor = ActorType.SURVIVOR;
        this.XP = 0;
        this.currentLevel = SurvivorsLevel.STARTING_LEVEL;
        this.actionPoint = 3;
        this.backPack = new ArrayList<>();
        this.inHand = new Pistol();
    }

    /**
     *@return type of Actor
     */
    public ActorType getTypeOfActor() {
        return this.typeOfActor;
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
public SurvivorsLevel getCurrentLevel(){
    if (this.XP <ELEVENTH_LEVEL){
        if (this.XP <=THIRD_LEVEL)
            return SurvivorsLevel.THIRD_LEVEL;
        //else
        return SurvivorsLevel.SEVENTH_LEVEL;
    }
    return SurvivorsLevel.ELEVENTH_LEVEL;
}


/**
 * @return the nickname of the survivor
 */
public String getNickName(){
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
     * Returns  level of expertise of a survivor
     * @return XP of survivor
     */
public int getLifePoints(){
    return this.lifePoint;
}
/**
 * Return all of  item present in the backpack
 * @return all item in backpack
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
    switch(this.XP){
        case 3:
            this.currentLevel = SurvivorsLevel.THIRD_LEVEL;
            increaseActionPoint();
        case 7:
            this.currentLevel = SurvivorsLevel.SEVENTH_LEVEL;
            increaseActionPoint();
        case 11:
            this.currentLevel = SurvivorsLevel.ELEVENTH_LEVEL;
            increaseActionPoint();
    }
}

/**
 * * Increase HP of survivor
 */
public void increaseLifePoints(){
    this.lifePoint++;
}
/**
 * decrease action points of survivor
 */
public void decreaseActionPoints(){
    this.actionPoint--;
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
 * It puts an item on cell. It can be an item that is on hand or in the backpack.
 * @param i the item we throw on cell
 */
public void putItemOnCell(Item i){
    if (backPack.contains(i))
        backPack.remove(i);
    super.cell.addItem(i);
}

/**
 * Take the item and put it in Backpack. If the number of item in backpack has reach 5, the oldest item added of the list will be
 * removed and replace by the wanted item.
 * If the item is taken from the cell of the survivor, then it will be remove of the cell when taken.
 * If the cell is a street, it will disapear and if it's a room it will be added to the list of item of the cell
 * @param i the item wanted in backpack
 */
public void putItemInBackpack(Item i){
    if (this.backPack.size()==MAX_NB_ITEM){
        Item oldestItem = this.backPack.get(0); // the oldest item added
        this.putItemOnCell(oldestItem);
    }
    if (this.cell.containsItem(i))
        this.cell.removeitem(i);
    this.backPack.add(i);
}

/**
 * When the survivor dies (or in other circumstances) all items of their backpack go on cell or disapear.
 * That method take all the items in backpack and drop it on cell.
 */
public void dropItALL(){
    for(Item i : backPack)
        putItemOnCell(i);
}

/** @return random result of a 1d6 throw*/
private int oneDieThrow() {
    return Survivor.randomNB.nextInt(6)+ 1;
}

/**
 * Throw several dice.
 * @param howMany the number of dice to throw
 * @return the result of dice throws
 */
public int diceThrows(int howMany){
    int result=0;
    for (int i=0; i<howMany+1; i++)
        result+= this.oneDieThrow();
    return result;
}

public String toString(){
    String description=  "Survivor name : "+ super.nickName+
            "\nin Hand : "+this.inHand+
            "\nXP : "+this.XP +
            "\nAction Point :"+this.actionPoint+
            "\nCurrent level : "+this.currentLevel+
            "\nin backpack : ";
    for (Item i: backPack){
        description+=";"+i+" ";
    }
    return description+".";

}


}
