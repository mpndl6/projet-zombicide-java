package zombicide.map.cell;
import java.util.Random;

import zombicide.item.Item;
import zombicide.map.util.*;
import zombicide.actor.survivor.*;
import zombicide.actor.zombie.*;
import zombicide.map.cell.util.*;

/** the street cell in the map */
public class Street extends Cell{

protected CellType cellType;


/** Construct a street
 */
public Street(){
    super();
    this.cellType = CellType.STREET;
}

 /**
  * get type of cell
  * 
  *@return type of cell 
  */
public CellType getTypeOfCell() {
    return this.cellType;
}

    @Override
    public String description() {
        return "Type cell :" + this +"\n" + "number of survivors:" + this.howManySurvivors() +"\n" + " number of zombies:" + this.howManyZombies() + "\n";
    }

    /**
     * 
     * @return true if it's possible to fith in this area
     */
    public boolean canFight() {
    	return true;
    }
    /**
     * @return a description of the cell
     */
    public String toString(){
        return "S";
    }
    

/** It returns the number of zombies we have to generate in a new phase of the game base to survivors XP
 * @return the number of zombies we have to generate
 */

/**
 * Adds an item to the Cell. In the street, the item is not added
 * @param i The item to be added.
 */
@Override
public void addItem(Item i){

}

/**
 * Removes an item from the room.
 * There's no item in the street.
 * @param i The item to be removed.
 */
@Override
public void removeItem(Item i){

}

/* à mettre dans dans  game ..
public int howManyZombiesToGenerate(){
    Random random = new Random();
    int randomZombies;
    int zombiesToGenerate;
    int averageExperience;
    int totalExperience = 0;
    for (Survivor s : super.survivors){
        totalExperience += s.getXP();
    }
    averageExperience = totalExperience/super.howManySurvivors();
    zombiesToGenerate = averageExperience/3;

    return  zombiesToGenerate;
}
*/


/*
 * a mettre dans game
 * add to the list of zombies

public void generateZombies(int howmany){
     int i=0;
     ZombieType random = ZombieType.random();
     Zombie zombie = ZombieType.createZombie(random);
     while(i<howmany){
        super.addZombies(zombie);
    }
*/
}



