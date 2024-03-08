package zombicide.actor.zombies.type;

import zombicide.actor.zombies.Zombie;

public class Abomination extends Zombie{
    public static final int ABOMINATION_DAMAGES=2;

    public Abomination(){
        super(ABOMINATION_DAMAGES);
    }

    public void takeDamage(){
        lifePoint-=ABOMINATION_DAMAGES;
        if(lifePoint<=0){
            System.out.println("L'abomination a été vaincu!");
        }else{
            System.out.println("L'abomination a subi des dégâts. Points de vie restants:"+lifePoint);

        }
    }
}
