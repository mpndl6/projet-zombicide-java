package zombicide.actor.survivor;
import exception.FullBackpackException;
import exception.NoSuchItemException;
import zombicide.Game;
import zombicide.action.*;
import zombicide.action.actionSurvivor.*;
import zombicide.actor.Actor;
import zombicide.actor.ActorType;
import zombicide.callable.Callable;
import zombicide.item.*;
import java.util.*;
import zombicide.item.weapon.*;

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
protected static final int STARTING_LEVEL =0; // at beginning a survivor is at level 0
public static final int MAX_NB_ITEM = 5; // in backpack
protected SurvivorsLevel currentLevel; // the level the survivor is currently in
protected String nickName; // nickname of survivor
protected int XP; // level of expertise of a survivor
protected Item inHand; // the item the survivor has in hand
protected List<Item> backPack;
protected int actionPoint;
protected ActorType typeOfActor;
private static Random randomNB = new Random( );
List<ActionSurvivor> actions;

/**
 *  Construct a survivor with their name in parameter.
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
    Item item = new Pistol();
    item.addSurvivor(this);
    this.inHand = item;
    this.nickName=name;
    this.actions = new ArrayList<>();
    initAction(); //init the list
}

/**
 * Gets th type of actor the survivor is
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
 * Gets the number of action points of the survivor
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
 * increase life points of actor
 */
public void increaseLifePoints(){
    this.lifePoint++;
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
 * decrease action points of survivor
 */
public void decreaseActionPoints(int nb){
    this.actionPoint= this.actionPoint - nb;
}


/**
 * set the amount of p action point
 * @param p the amount
 */
public void setActionPoint(int p){
    this.actionPoint = p;
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
public void setInHand(Item i ){
    this.inHand=i;
}

    /*
public void putInHand(Item i) throws FullBackpackException {
    if(hasItemOnHand())
        putItemInBackpack(this.inHand);
    this.inHand = i;
    i.addSurvivor(this);
} // La méthode sera peut-être enlever étant donné que nous avons les actions
     */

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
 * Take the item and put it in Backpack. If the number of item in backpack has reach the maximum, the oldest item added of the list will be
 * removed and replace by the wanted item.
 * If the item is taken from the cell of the survivor, then it will be removed of the cell when taken.
 * If the cell is a street, it will disapear and if it's a room it will be added to the list of item of the cell
 * @param i the item wanted in backpack
 */
public void putItemInBackpack(Item i) throws FullBackpackException{
    if (this.backPack.size()==MAX_NB_ITEM){
        throw new FullBackpackException("Backpack full");
    }
    if (this.cell.containsItem(i))
        this.cell.removeItem(i);
    this.backPack.add(i);
}
/**
 * remove an item of the backpack
 * @param item the item wanted out of the backpack
 * */
public void removeItemFromBackpack(Item item) {
    this.backPack.remove(item);
}
public static Item chooseItemToDiscard( Survivor s) {
    List<Item> backpack = s.getAllInBackpack();
    if (backpack.isEmpty()) {
        return null;
    } else {
        Random random = new Random();
        int index = random.nextInt(backpack.size());
        Item discardedItem = backpack.get(index);
        backpack.remove(index);
        return discardedItem;
    }
}

/**
 * When the survivor dies (or in other circumstances) all items of their backpack go on cell or disappear.
 * That method take all the items in backpack and drop it on cell.
 */
public void dropItALL(){
    List<Item> itemsToRemove = new ArrayList<>(backPack); // Créez une copie de la liste
    for (Item item : itemsToRemove) {
        putItemOnCell(item); // Mettez chaque élément dans la cellule
    }
    backPack.clear();
}

/**
 *  Provides on die throw
 * @return random result of the throw
 */
private int oneDieThrow() {
    return Survivor.randomNB.nextInt(6)+ 1;
}

/**
 * Throw several dice according to the number in parameter
 * @param howMany the number of dice to throw
 * @return the result of dice throws
 */
public int diceThrows(int howMany){
    int result = 0;
    for (int i = 0; i < howMany; i++) {
        result += this.oneDieThrow();
    }
    return result;
}

/**
 * Gives a precise description of the survivor
 * @return the description of the survivor
 */
public String toString(){
String description=  "Survivor name : "+ super.nickName;
        if (this.alive) {
            description += "\nStatus : alive";
            description += "\nPoint de vie : " + this.lifePoint;
        }
        else
            description+="\nStatus : dead...";

        description+="\nIn Hand : "+this.inHand+
        "\nXP : "+this.XP +
        "\nAction Point : "+this.actionPoint+
        "\nCurrent level : "+this.currentLevel+
        "\nIn backpack : ";

        for (Item i: backPack){
            description+=i+" ";
        }
        description+="\nKills : "+super.kills;
return description+"";

}

    /**
     * Permet de récuperer une action qu'on va utiliser pour le zombie
     * @param a index of the listActionZombie
     * @return an of  the list
     */
    public Action getAction(int a){
        return actions.get(a);
    }


    /**
     * Init the list of actions of the current survivor
     */
    protected void initAction(){
        ActionSurvivor move = new MoveAside(this);
       // ActionSurvivor open = new OpenDoor(this, this.getGame().getMap());
        ActionSurvivor search = new Search(this);
        ActionSurvivor take = new TakeInHand(this);
        ActionSurvivor use = new UseItem(this);
        ActionSurvivor attack = new AttackSurvivor(this);
        ActionSurvivor look = new LookAround(this);
        ActionSurvivor makeNoise = new MakeNoise(this);


        actions.add(move);
       // actions.add(open);
        actions.add(search);
        actions.add(take);
        actions.add( use);
        actions.add(attack);
        actions.add(look);
        actions.add(makeNoise);
    }


    /**
     * Permits to add an action to the list of actions
     * @param action the action to add
     */
    public void addAction(ActionSurvivor action){
        this.actions.add(action);
    }

    /**
     * Return the list of the actions that can do the survivor
     * @return the List of actions.
     */
    public List<ActionSurvivor> getActions(){
        return actions;
    }

    /**
 * The survivor realises an action. Based on their role they can or not realise the action
 * @param action The action wanted by the survivor
 * @param callable any object in this game that is callable. Will be cast depending on the action.
 * @return true if the action has been made with success
 */
public boolean makeAction(ActionSurvivor action, Callable callable){


boolean actionMade = action.make(callable);
if (actionMade) {
    this.decreaseActionPoints(action.getCost());
    return true;
}
return false;
}


}
