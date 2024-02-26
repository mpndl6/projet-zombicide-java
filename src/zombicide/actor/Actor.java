package zombicide.actor;
import zombicide.map.cell.*;
public abstract class Actor {

protected Cell cell;
protected int lifePoint; // life points of the survivor
protected String nickName;
/**
 *
 */
public Actor(String name){
    this.nickName=name;
    this.lifePoint = 5;
}

    /**
     * increase life points of survivor
     */
    public void increaseLifePoint(){
        this.lifePoint++;
    }
}
