package zombicide.action.actionZombie;

import zombicide.action.actionZombie.ActionZombie;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.callable.Callable;

import java.util.ArrayList;
import java.util.List;

/**
 * This action attack is for the zombies that attack Survivors
 */
public class AttackZombie extends ActionZombie {

    /**
     *
     * @param z
     */
    public AttackZombie(Zombie z) {
        super(z);
    }

    /**
     * Performs the action of attacking a zombie by a zombie;
     * @param callable the callable, here it's an instance of Survivor
     * @return true if the action has been done successfully
     */
    @Override
    public boolean make(Callable callable){
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
            target.beingAttacked();
            if (!target.isAlive()){
                System.out.println(target.getNickName()+" is dead.");
            }

            return true;

        }
        return false;
    }

    /**
     * The zombie can always attack a survivor on the same cell as its
     * @return true, always
     */
    @Override
    public boolean canMakeAction() {
        return true;
    }


}
