package zombicide.actor.zombie;

import zombicide.action.Action;
import zombicide.actor.Actor;
import zombicide.actor.ActorType;
import zombicide.callable.Callable;
import zombicide.item.Item;

/**
 * Class abstract Zombie. Zombies must have a precise type
 */
public abstract class Zombie extends Actor {

protected final int DAMAGES;
protected ActorType typeOfActor;

/**
 * Constrcuts a Zombie
 * @param name name of the zombie
 * @param damage the damage it inflicts
 * @param lp the lifePoint it has at creation
 */
 public Zombie (String name, int damage, int lp){
     super(name,lp);
     this.typeOfActor = ActorType.ZOMBIE;
     this.DAMAGES = damage;
 }

/**
 *
 * @return the damage inflicted by the zombie
 */
 public int howManyDamages(){
     return DAMAGES;
 }

/**
 *@return type of Actor
 */
public ActorType getTypeOfActor() {
    return this.typeOfActor;
}


/**
 * Gives a precise description of the Zombie
 * @return the description of the zombie
 */
public String toString(){
    String description=  "Zombie type : "+ super.nickName;
    if (super.alive)
        description+="\nStatus : alive";
    else
        description+="\nStatus : dead...";

    description+="\nDamage : "+this.howManyDamages()+
            "\nKills : "+super.kills;

    return description+"";

}

    public void makeAction(Action action, Callable callable){
        action.make(callable);
    }


}
