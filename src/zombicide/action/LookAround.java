package zombicide.action;

import zombicide.actor.survivor.Survivor;

public class LookAround extends Action{
    public LookAround(Survivor s) {
        super(s);
        this.cost = 0;
    }

    @Override
    public void make() {
        this.survivor.getCell().description();
    }
}
