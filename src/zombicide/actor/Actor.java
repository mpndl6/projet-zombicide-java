package zombicide.actor;
import zombicide.callable.Callable;
import zombicide.map.cell.*;
public abstract class Actor implements Callable {
protected Cell cell;
protected int lifePoint; // life points of the survivor
protected String nickName;
protected boolean alive;

/**
 * Constrcut an actor
 * @param name the name or nickname of the actor
 * @param lp the life points they got at creation
 */
public Actor(String name, int lp){
    this.nickName=name;
    this.lifePoint = lp;
    this.alive = true;
}

/**
 * Tells if a survivor is dead or alive
 * @return true if the survivor is alive, false otherwise
 */
public boolean isAlive(){
    return this.alive;
}


/**
 * increase life points of actor
 */
public void increaseLifePoints(){
    this.lifePoint++;
}

/**
 * decrease the life point of a survivor. If their life point reach 0, they die
 */
public void decreaseLifePoints(){
    this.lifePoint--;
    if (this.lifePoint==0)
        this.alive=false;
}

/**
 * This method inflicts one damage to the current actor.
 * @return true if this one damage is fatal to the actor (if they die basically)
 */
public boolean takeDamage(){
    this.lifePoint--;
    return this.lifePoint==0;
}

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

/**
 * Method to know the type of actor the actor is
 * @return the type of actor the actor is
 */
public abstract ActorType getTypeOfActor();

    //methode action

}