package zombicide.map.cell;
import java.util.Random;
import zombicide.map.util.*;
import zombicide.actor.survivors.*;
import zombicide.actor.zombies.*;
import zombicide.map.cell.util.*;

/** the street cell in the map */
public class Street extends Cell{

protected CellType cellType;


/** Construct a street
 * @param p the position of the cell street
 */
public Street(Position p){
    super(p);
    this.cellType = CellType.STREET;
}

public Street (Position p){
    super(p);
}


public boolean canFight() {
    	return true;
    }

/** It returns the number of zombies we have to generate in a new phase of the game base to survivors XP
 * @return the number of zombies we have to generate
 */


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



