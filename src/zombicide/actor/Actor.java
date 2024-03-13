package zombicide.actor;
import zombicide.map.cell.*;
public abstract class Actor {
protected Cell cell;
protected int lifePoint; // life points of the survivor
protected String nickName;
/**
 *
 */
public Actor(String name, int lp){
    this.nickName=name;
    this.lifePoint = lp;
}

    /**
     * increase life points of survivor
     */
    public void increaseLifePoint(){
        this.lifePoint++;
    }

    /**
     * This method inflicts one damage to the current actor.
     * @return true if this one damage is fatal to the actor (if they die basically)
     */
    public boolean takeDamage(){
        this.lifePoint--;
        return this.lifePoint==0;
    };

    /**
     * Gets the cell where the actor is located.
     * @return The cell where the actor is located.
     */
    public Cell getCell(){
        return this.cell;
    }

    /**
     * Sets the cell where the actor is located.
     * @param c The cell to set.
     */
    public void setCell(Cell c){
        this.cell = c;
    }

    public abstract ActorType getTypeOfActor();

    //methode action

}