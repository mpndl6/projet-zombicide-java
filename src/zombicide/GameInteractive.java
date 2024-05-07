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
import zombicide.map.util.Position;

import java.util.Iterator;
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
        initActionOfSurvivors();
        ListChooser<ActionSurvivor> actionSurvivorListChooser = new InteractiveListChooser<>();
        ListChooser<Callable> choices = new InteractiveListChooser<>();
        int i = 1;
        System.out.println("Survivors present in the game :");


        while (!super.isFinished()) {
            numberOfTurns++;
            System.out.println("TOUR N°"+i);
            System.out.println("___________________________ PHASE DES SURVIVANTS ________________________________ \n");
            Iterator<Survivor> iterator = listSurvivors.iterator();
            while (iterator.hasNext()) {
                Survivor s = iterator.next();
                if (!s.isAlive()) {
                    iterator.remove(); // Supprimez le survivant de la liste en toute sécurité
                    continue; // Passez au prochain survivant
                }
                while(s.getActionPoint()!=0){

                    System.out.println("Current survivor : "+s.getNickName()+"\n");

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
                        System.out.println(s.getNickName() + " just made the action : " + action+"\n\n");
                    else{
                        System.out.println(s.getNickName()+" couldn't do the action : "+action);
                        System.out.println();
                    }

                }
                System.out.println(s);
                System.out.println();
            }

            System.out.println("_____________________________________________________________________________________");
            if(!listZombies.isEmpty()){
                System.out.println("_________________________________ PHASE DES ZOMBIES _________________________________ \n");
                for (Zombie zombie : listZombies) {
                    ActionZombie actionAttack = zombie.getAction(1);
                    if (actionAttack.make(null)) {
                        System.out.println(zombie.getNickName()+" attacked\n");
                        grid.displayGrid();
                    }
                    else {
                        ActionZombie actionMove = zombie.getAction(0);
                        boolean move = zombie.makeAction(actionMove, this.getRandomNoiseCell());
                        if(!move){
                            System.out.println(zombie.getNickName() + " tried to move but had an obstacle.\n");
                            move = zombie.makeAction(actionMove, this.getRandomNoiseCell()); //On bouge vers la même cellule
                        }
                        grid.displayGrid();
                    }

                }
            }
            System.out.println("END OF TOUR.\n");
            this.removeDeadActors();
            this.NoiseDown();
            this.SetActionPointSurvivor();
            i++;

            if (super.isFinished()) {
                break;
            }

            this.spawnZombies(3);



        } //fin du while
        System.out.println("Le jeu est terminé\n");
    }
}
