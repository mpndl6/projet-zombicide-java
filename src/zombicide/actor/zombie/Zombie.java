package zombicide.actor.zombie;

import zombicide.action.Action;
import zombicide.action.actionZombie.ActionZombie;
import zombicide.action.actionZombie.AttackZombie;
import zombicide.action.actionZombie.MoveAsideZombie;
import zombicide.actor.Actor;
import zombicide.actor.ActorType;
import zombicide.callable.Callable;

import java.util.ArrayList;
import java.util.List;

/**
 * Class abstract Zombie. Zombies must have a precise type
 */
public abstract class Zombie extends Actor {

protected final int DAMAGES;
protected ActorType typeOfActor;

protected List<ActionZombie> listActionZombie;


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
     this.listActionZombie = new ArrayList<>();
     MoveAsideZombie move = new MoveAsideZombie(this);
     AttackZombie attack = new AttackZombie(this);
     listActionZombie.add(move);
     listActionZombie.add(attack);
 }

    /**
     * Permet de récuperer une action qu'on va utiliser pour le zombie
     * @param a index of the listActionZombie
     * 0 : move
     * 1 : attack
     * @return an of  the list
     */
 public ActionZombie getAction(int a){
     return listActionZombie.get(a);
 }
/**
 * to know how can deal (damage) a zombie
 * @return the damage inflicted by the zombie
 */
 public int howManyDamages(){
     return DAMAGES;
 }

/**
 * to know the type of actor
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

    public boolean makeAction(Action action, Callable callable){
        return action.make(callable);
    }


}
