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
public class AttackZombie implements ActionZombie {
    protected Zombie zombie;

    /**
     * Construct a AttackZombie
     * @param z the zombie linked to this method
     */
    public AttackZombie(Zombie z) {
        this.zombie = z;
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
     * Retrieves the zombie linked to this action
     * @return the zombie linked to this action
     */
    @Override
    public Actor getActor() {
        return this.zombie;
    }


}
