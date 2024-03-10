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

    public void takeDamage(){
        this.lifePoint--;
    };
}
