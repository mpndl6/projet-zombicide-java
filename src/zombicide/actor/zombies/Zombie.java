package zombicide.actor.zombies;

import zombicide.actor.Actor;

public abstract class Zombie extends Actor {
    protected static final int DAMAGES=0;
     public int lifePoint;

     public Zombie (int lp){
         super();
         this.lifePoint=lp;
     }

     public int howManyDamages(){
         return DAMAGES;
     }

     public abstract void takeDamage();
}
