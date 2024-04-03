package zombicide.map.cell.room;

import zombicide.actor.Actor;
import zombicide.actor.PNJ;
import zombicide.actor.zombie.Zombie;

public class Armory extends SpecialRoom{

    protected PNJ pnj;

    public Armory(){
        super();
        this.pnj = null;
    }

    /**
     *
     */
    /**
     * Adds an actor to the cell
     *@param a to be added to the cell
     */
    public void welcomeActor(Actor a){
        if(a instanceof Zombie)
            return;

        boolean hasSucced = this.pnj.welcomeSurvivor();
        if(hasSucced){
            this.pnj.fabricate();
        }

    }

    /**
     *
     */
    public void setPNJ(PNJ p){
        this.pnj = p;
    }



}
