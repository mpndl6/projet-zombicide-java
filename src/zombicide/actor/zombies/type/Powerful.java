package zombicide.actor.zombies.type;

import zombicide.actor.zombies.Zombie;

public class Powerful extends Zombie {
    public static final int POWERFUL_DAMAGES=3;

    public Powerful(){
        super(POWERFUL_DAMAGES);
    }

    public void takeDamage(){
        lifePoint-=POWERFUL_DAMAGES;
        if(lifePoint<=0){
            System.out.println("Le Powerful a été vaincu!");
        }else{
            System.out.println("Le Powerful a subi des dégâts. Points de vie restants:"+lifePoint);

        }
    }
}
