package zombicide.map.cell.room;

import zombicide.actor.Actor;
import zombicide.actor.PNJ;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.item.Item;
import zombicide.item.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        super.welcomeActor(survivor);
        boolean hasSucced = this.pnj.welcome(survivor);
        if(hasSucced){
            System.out.println("What do you want? :");
            System.out.println("1 - AMELIORATE ");
            System.out.println("2 - FABRICATE");
            boolean response = this.pnj.generateRandomResponse();
            if(response)
                this.pnj.fabricate();
            else
                this.pnj.ameliorate(survivor);
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
     * @return
     */
    public PNJ getPnj(){
        return this.pnj;
    }

    /**
     *
     */
    public String toString(){
        return "A*";
    }


}
