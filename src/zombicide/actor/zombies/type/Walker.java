package zombicide.actor.zombies.type;

import zombicide.actor.zombies.Zombie;

public class Walker extends Zombie{
    public static final int WALKER_DAMAGES=1;
    public Walker(){
        super(WALKER_DAMAGES);
    }

    public void takeDamage(){
        lifePoint-=WALKER_DAMAGES;
        if(lifePoint<=0){
            System.out.println("Le Walker a été vaincu!");
        }else{
            System.out.println("Le Walker a subi des dégâts. Points de vie restants:"+lifePoint);

        }
    }
    
}
