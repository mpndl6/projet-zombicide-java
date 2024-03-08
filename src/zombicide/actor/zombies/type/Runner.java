package zombicide.actor.zombies.type;

import zombicide.actor.zombies.Zombie;

public class Runner extends Zombie{
    public static final int RUNNER_DAMAGES=1;
    public Runner(){
        super(RUNNER_DAMAGES);
    }

    public void takeDamage(){
        lifePoint-=RUNNER_DAMAGES;
        if(lifePoint<=0){
            System.out.println("Le Runner a été vaincu!");
        }else{
            System.out.println("Le Runner a subi des dégâts. Points de vie restants:"+lifePoint);

        }
    }
}
