package zombicide.action.actionSurvivor;

import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.callable.Callable;

import java.util.ArrayList;
import java.util.List;

public class GetStatus implements ActionSurvivor{

    protected Survivor survivor;
    public static final int GET_STATUS_COST =0;

    public GetStatus(Survivor s){
        this.survivor = s;
    }
    @Override
    public boolean make(Callable callable) {
        System.out.println(survivor);
        return true;
    }

    @Override
    public Actor getActor() {
        return this.survivor;
    }

    @Override
    public boolean canMakeAction() {
        return true;
    }

    @Override
    public int getCost() {
        return GET_STATUS_COST;
    }

    @Override
    public List<Callable> getChoices() {
        return new ArrayList<>();
    }

    public String toString(){
        return "get my status";
    }
}
