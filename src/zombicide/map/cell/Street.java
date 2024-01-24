package zombicide.map.cell;
import java.util.Random;
import zombicide.actors.*;

import zombicide.util.Position;

/** the street cell in the map */
public class Street {

/** streets have or not a wastewater on where the zombies go out*/
protected boolan wastewater;

/** Construct a street
 * We can set a wastewater or not on the cell
 * @param p the position of the cell street
 * @param hasWastewater is true when the street constains a wastewater
 */
public Street(Position p, boolean hasWastewater){
    super(p);
    this.wastewater=hasWastewater;
}

/**
 * @return true if the cell street constains a wastewater
 */
public boolean hasWastewater(){
    return this.wastewater;
}

/** It returns the number of zombies we have to generate in a new phase of the game base to survivors XP
 * @return the number of zombies we have to generate
 */
public int howManyZombiesToGenerate(){
    Random random = new Random();
    int randomZombies;
    int zombiesToGenerate;
    int averageExperience;
    int totalExperience = 0;
    for (survivor s : super.survivors){
        totalExperience += s.getXP();
    }
    averageExperience = totalExperience/super.howManySurvivors();
    zombiesToGenerate = averageExperience/3;
    randomZombies =  random.nextInt(zombiesToGenerate)+1;    

    return randomZombies;
}



/**
 * add to the list of zombies 
 */
public void generateZombies(int howmany){
     int i=0;
     int random = ZombieType.random();
     Zombie zombie = ZombieType.createZombie(random);
     while(i<howmany){
        super.survivors.add(zombie);
    }

}


}
