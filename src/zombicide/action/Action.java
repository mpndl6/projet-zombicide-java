package zombicide.action;

import zombicide.actor.survivor.Survivor;

public abstract class Action {

    protected int cost;
    protected Survivor survivor;

    public Action(Survivor s) {
        this.cost = 1;
        this.survivor = s;
    }

    public int getCost(){
        return this.cost;
    }

    public Survivor getSurvivor(){
        return this.survivor;
    }

    public abstract void make();
}
