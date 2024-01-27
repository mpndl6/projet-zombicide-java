package zombicide.actor.zombies;
import java.util.Random;
import zombicide.actor.zombies.type.*;

public enum ZombieType {

 WALKER,POWERFUL,ABOMINATION, RUNNER;

private static Random ALEA = new Random();

/**
* return a randomly chosen ZombieType
* @return a randomly chosen ZombieType
*/
public static ZombieType random() {
    return ZombieType.values() [ ALEA.nextInt(ZombieType.values().length) ];
}

 /**
 * @return the zombie of the type in parameter
 * @param z the zombietype we want to return
*/
public static Zombie createZombie(ZombieType z){

    switch (z){
        case WALKER:
            return new Walker();
        
        case RUNNER:
            return new Runner();
        
        case POWERFUL:
            return new Powerful();
        
        case ABOMINATION:
            return new Abomination();

        default:
            return new Zombie();
    }
}

}
