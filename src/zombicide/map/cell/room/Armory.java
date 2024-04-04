package zombicide.map.cell.room;

import zombicide.actor.Actor;
import zombicide.actor.PNJ;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.item.Item;

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
    @Override
    public void welcomeActor(Actor a){
        if(a instanceof Zombie)
            return;
        Survivor survivor = (Survivor)a;
        boolean hasSucced = this.pnj.welcome(survivor);
        if(hasSucced){

            this.pnj.fabricate();
            //input B - ameliorate an waepon
            Item input = null;
            this.pnj.ameliorate(input);
            //int C - ne rien faire
            System.out.println("Shme. OK");
        }

    }

    /**
     *
     */
    public void setPNJ(PNJ p){
        this.pnj = p;
    }

    /**
     *
     */



    /**
     *
     */
    public String toString(){
        return "A*";
    }


}
