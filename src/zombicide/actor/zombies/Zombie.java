package zombicide.actor.zombies;

import zombicide.actor.Actor;

public abstract class Zombie extends Actor {
    protected final int DAMAGES;
    protected int lp;

     public Zombie (String name, int damage){
         super(name);
         this.lifePoint=lp;
         this.DAMAGES = damage;
     }
     public int howManyDamages(){
         return DAMAGES;
     }

}
