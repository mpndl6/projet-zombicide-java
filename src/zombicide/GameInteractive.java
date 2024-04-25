package zombicide;

import listchooser.InteractiveListChooser;
import listchooser.ListChooser;
import listchooser.RandomListChooser;
import zombicide.action.actionSurvivor.ActionSurvivor;
import zombicide.action.actionZombie.ActionZombie;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.callable.Callable;
import zombicide.item.weapon.Pistol;
import zombicide.map.Map;

import java.util.List;

public class GameInteractive extends Game{

    /**
     * Construct a new game with  map at construction
     *
     * @param map the map of the game
     */
    public GameInteractive(Map map) {
        super(map);
    }

    /**
     *
     */
    /**
     * Run the game
     */
    @Override
    public void run() {
        super.initActionOfSurvivors();
        ListChooser<ActionSurvivor> actionSurvivorListChooser = new InteractiveListChooser<>();
        ListChooser<Callable> choices = new InteractiveListChooser<>();
        int i = 1;
        System.out.println("Survivors present in the game :");
        for(Survivor s : listSurvivors) {
            System.out.println(s.getNickName());
            Pistol p = (Pistol)s.getWhatINHand();
            p.setMap(this.map);
        }
        System.out.println();

        while (!isFinished()) {
            System.out.println("TOUR N°"+i);
            System.out.println("PHASE DES SURVIVANTS \n");
            for (Survivor s : listSurvivors) {
                if(!s.isAlive()){
                    break;
                }
                System.out.println(s);

                this.grid.displayGrid();

                ActionSurvivor action = actionSurvivorListChooser.choose(s.getNickName()+" choose one : ", s.getActions());
                List<Callable> actionChoises = action.getChoices();
                Callable choice;
                System.out.println(s.getNickName() +" choose the action : "+ action+"\n");
                if (!actionChoises.isEmpty()) {
                    choice = choices.choose("WHICH ONE?", actionChoises);
                    System.out.println("CHOICE : " + choice);
                }
                else
                    choice = null;

                boolean actionMade = s.makeAction(action, choice);
                if (actionMade)
                    System.out.println(s.getNickName() + " just made the action :" + action+"\n");
                else
                    System.out.println(s.getNickName()+" couldn't do the action : "+action);

            }
            if(!listZombies.isEmpty()){
                System.out.println("PHASE DES ZOMBIES \n");
                for (Zombie zombie : listZombies) {
                    grid.displayGrid();

                    ActionZombie actionAttack = zombie.getAction(1);
                    if (actionAttack.make(zombie.getCell())) {
                        System.out.println(zombie.getNickName()+" attacked\n");
                        grid.displayGrid();
                    }
                    else {
                        ActionZombie actionMove = zombie.getAction(0);
                        boolean move = zombie.makeAction(actionMove, this.getRandomNoiseCell());
                        if (!move)
                            System.out.println(zombie.getNickName() + " tried to move but has an obstacle.\n");
                        grid.displayGrid();
                    }

                }
            }
            System.out.println("END OF TOUR.\n");
            this.removeDeadActors();
            this.NoiseDown();
            this.SetActionPointSurvivor();
            this.spawnZombies(3);
            i++;

        } //fin du while
        System.out.println("Le jeu est terminé\n");
    }
}
