package zombicide.map.cell.room;
import zombicide.actor.Actor;
import zombicide.item.utility.Vial;
import zombicide.map.cell.*;
import zombicide.map.util.*;
import zombicide.actor.survivors.Survivor;


public class DrugStore extends SpecialRoom {

    /**
     * It creates the DrugStore of the Map
     * @param p position of the drugStore
     * @param w width of Map
     * @param h heigth of Map
     */
    public DrugStore(Position p, int w,int h){
        super(p,w,h);
    }

    /**
     * Adds a survivor to the cell
     * @param a to be added to the cell
     * When a wurvivor enters into the Drugstore, its icrease the number of vials
     */
    public void welcomeActor(Actor a){
        super.welcomeActor(a);
        if (a instanceof Survivor)
            super.items.add(new Vial());
    }

    /**
     * @return a descrption of the cell
     */
    public String toString(){
        return "D";
    }


}
