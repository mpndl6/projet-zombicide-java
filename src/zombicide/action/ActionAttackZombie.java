package zombicide.action;

import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.callable.Callable;
import zombicide.map.cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class ActionAttackZombie extends  ActionZombie{

    public ActionAttackZombie(Zombie z) {
        super(z);
    }

    /**
     * Performs the action of making the action attack by an survivor;
     */
    @Override
    public boolean make(Callable callable) throws Exception {
        if(this.zombie.getCell().howManySurvivors()>0){
            List<Survivor> listSurvivor = new ArrayList<>();
            List<Actor> listActors = this.zombie.getCell().getActors();
            for(Actor survivor : listActors){
                if(survivor instanceof Survivor){
                    listSurvivor.add((Survivor) survivor);
                }
            }
            int size = listSurvivor.size();
            int n = (int)(Math.random() * size);
            Survivor target = listSurvivor.get(n);
            target.decreaseLifePoints();
            return true;

        }
        return false;
    }

    /**
     * Verify if the survivor can attack or not( verify if he had a weapon in their hands)
     */
    @Override
    public boolean canMakeAction() {
        return true;
    }


}
