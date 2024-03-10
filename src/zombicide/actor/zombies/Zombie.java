package zombicide.actor.zombies;

import zombicide.actor.Actor;

public abstract class Zombie extends Actor {
    protected final int DAMAGES;

     public Zombie (String name, int damage, int lp){
         super(name,lp);
         this.DAMAGES = damage;
     }
     public int howManyDamages(){
         return DAMAGES;
     }

}
