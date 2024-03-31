package zombicide.action;

import zombicide.actor.survivor.Survivor;

public class MakeNoise extends ActionSurvivor{

    public MakeNoise(Survivor s) {
        super(s);

    }
    @Override
    public void make() {
        this.survivor.getCell().makenoise();

    }
}
