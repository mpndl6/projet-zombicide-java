package zombicide.actor.zombies;

import java.util.Random;

public enum ZombyType {

 WALKER,POWERFUL,ABOMINATION, RUNNER;


private static Random ALEA = new Random();

/**
* return a randomly chosen ZombieType
* @return a randomly chosen ZombieType
*/
public static ZombyType random() {
    return ZombyType.values() [ ALEA.nextInt(ZombyType.values().length) ];
}

 /**
 * @return the zombie of the type in parameter
 * @param z the zombietype we want to return
 */
public static Zombie createZombie(ZombyType z){

    switch (z){
        case WALKER:
            return new Walker(); 
        
        case RUNNER:
            return new Runner();
        
        case POWERFUL:
            return new PowerfulZombie();
        
        case ABOMINATION:
            return new Abomination();

        default:
            return new Zombie();
    }
}


}
