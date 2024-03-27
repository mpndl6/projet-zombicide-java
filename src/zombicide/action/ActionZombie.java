package zombicide.action;

import zombicide.actor.zombie.Zombie;

public abstract class ActionZombie implements Action{
    protected int cost;
    protected Zombie zombie;

    public ActionZombie(Zombie z) {
        this.cost = 1;
        this.zombie = z;
    }

    public int getCost(){
        return this.cost;
    }

    public Zombie getSurvivor(){
        return this.zombie;
    }

    public abstract void make();
}
