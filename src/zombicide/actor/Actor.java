package zombicide.actor;
import zombicide.Game;
import zombicide.callable.Callable;
import zombicide.map.cell.*;
public abstract class Actor implements Callable {
protected Cell cell;
protected int lifePoint; // life points of the survivor
protected String nickName;
protected boolean alive;
protected int kills;

protected Game game;

/**
 * Constrcut an actor
 * @param name the name or nickname of the actor
 * @param lp the life points they got at creation
 */
public Actor(String name, int lp){
    this.nickName=name;
    this.lifePoint = lp;
    this.alive = true;
    this.kills=0;
    this.game=null;
}

/**
 * Tells if a survivor is dead or alive
 * @return true if the survivor is alive, false otherwise
 */
public boolean isAlive(){
    return this.alive;
}

/**
 * Tells how many kills has been done by the actor
 * @return the nb of kills
 */
public int getHowManyKills(){
    return this.kills;
}


/**
 * decrease the life point of a survivor. If their life point reach 0, they die
 */
public void beingAttacked(){
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
 * Gets the game where the actor is located.
 * @return The game where the actor is located.
 */
public Game getGame(){
        return this.game;
    }

/**
 * Sets the cell where the actor is located.
 * @param c The cell to set.
 */
public void setCell(Cell c){
    this.cell = c;
}

/**
 * Sets the game where the actor is located.
 * @param g The game to set.
 */
public void setGame(Game g){
        this.game = g;
    }

/**
 * Gets the nickname of  the survivor
 * @return the nickname of the survivor
 */
public String getNickName(){
    return this.nickName;
}


/**
 * Method to know the type of actor the actor is
 * @return the type of actor the actor is
 */
public abstract ActorType getTypeOfActor();

    //methode action
/**
 * Returns  lifePoints of a survivor
 * @return lifePoints of actor
 */
public int getLifePoints(){
    return this.lifePoint;
}

}