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
     * @param s
     * @return
     */
    public Weapon getRandomWeapon(Survivor s){
        Random rand = new Random();
        int backPackSize = s.getAllInBackpack().size();
        int n = (int) Math.round(Math.random() * backPackSize);
        List<Item> backPackOfSurvivor = s.getAllInBackpack();
        List<Weapon> weaponsOfSurvivor = new ArrayList<>();
        for (Item i : backPackOfSurvivor){
            if (i instanceof Weapon)
                weaponsOfSurvivor.add((Weapon)i);
        }
        return weaponsOfSurvivor.get(n);
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
            System.out.println("What do you want? :");
            System.out.println("1 - AMELIORATE ");
            System.out.println("2 - FABRICATE");
            boolean response = this.pnj.generateRandomResponse();
            if(response)
                this.pnj.fabricate();
            else {
                System.out.println("Which weapon do you want to ameliorate?");

                this.pnj.ameliorate(input);
            }
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
