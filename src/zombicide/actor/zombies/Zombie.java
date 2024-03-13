package zombicide.actor.zombies;

import zombicide.actor.Actor;
import zombicide.actor.ActorType;
import zombicide.map.cell.util.CellType;

public abstract class Zombie extends Actor {
    protected final int DAMAGES;
    protected ActorType typeOfActor;

     public Zombie (String name, int damage, int lp){
         super(name,lp);
         this.typeOfActor = ActorType.ZOMBIE;
         this.DAMAGES = damage;
     }
     public int howManyDamages(){
         return DAMAGES;
     }

    /**
     *@return type of Actor
     */
    public ActorType getTypeOfActor() {
        return this.typeOfActor;
    }


}
