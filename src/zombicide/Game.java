package zombicide;

import listchooser.ListChooser;
import listchooser.RandomListChooser;
import zombicide.action.Action;
import zombicide.action.actionSurvivor.ActionSurvivor;
import zombicide.action.actionZombie.ActionZombie;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.survivor.SurvivorsLevel;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.ZombieType;
import zombicide.callable.Callable;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import java.util.*;

import static zombicide.actor.zombie.ZombieType.createZombie;
import static zombicide.actor.zombie.ZombieType.random;

/**
 * Class of the game
 */
public class Game {

    public static final int MAX_GLOBAL_XP = 30;

    protected Map map;
    protected List<Survivor> listSurvivors;
    protected List<Zombie> listZombies;
    protected List<Actor> actors;

    /**
     * Construct a new game with  map at construction
     * @param map the map of the game
     */
    public Game(Map map) {
        this.map = map;
        this.listSurvivors = new ArrayList<>();
        this.listZombies = new ArrayList<>();
        this.actors = new ArrayList<>();
    }

    /**
     * Verify if there's doors open between two positions
     * @param p1 first position
     * @param p2 second position
     * @return true the doors between are open
     */
    public boolean doorsBetween(Position p1, Position p2) {
        int x1 = p1.getX();
        int y1 = p1.getY();
        int x2 = p2.getX();
        int y2 = p2.getY();
        boolean res = true;
        if (x1 == x2) {
            if (x1 > x2) {
                for (int i = x1; i > x2; i--) {
                    res = res && this.map.isOpenDoor(this.map.getCell(new Position(i, y1)), Location.WEST);

                }
            }
            if (x1 < x2) {
                for (int i = x1; i < x2; i++) {
                    res = res && this.map.isOpenDoor(this.map.getCell(new Position(i, y1)), Location.EAST);

                }
            }
        }
        if(y1 == y2) {
            if (y1 > y2) {
                for (int i = y1; i > y2 ; i--) {
                    res = res && this.map.isOpenDoor(this.map.getCell(new Position(x1,i)), Location.NORTH);

                }
            }
            if (y1 < y2) {
                for (int i = y1; i < y2 ; i++) {
                    res = res && this.map.isOpenDoor(this.map.getCell(new Position(x1,i)), Location.SOUTH);

                }
            }
        }
        return res;
    }

    /**
     * swapan Random zombies
     * @param random how many zombies can be spawn
     */
    public void spawnZombies(int random){
        int n = (int)(Math.random() * random);
        for(int i=0;i<n;i++){
            ZombieType randomType = random();
            Zombie zombie = createZombie(randomType);
            Position location =  this.map.getPositionOFWaster(Location.randomLocation());
            addZombieGame(zombie);
            this.map.putActorONCell(zombie,location);

    }}

    /**
     * Retrieves the map of the game
     * @return the map of the game
     */
    public Map getMap(){
        return this.map;
    }

    /**
     * Add a survivor to the game
     * @param s the survivors we want to add
     */
    public void addSurvivorGame(Survivor s){
        listSurvivors.add(s);
        actors.add(s);
    }

    /**
     * Add a zombie to the game
     * @param z the zombie we want to add
     */
    public void addZombieGame(Zombie z){
        listZombies.add(z);
        actors.add(z);
    }

    /**
     * Add an actor to the game
     * @param a the actor we want to add
     */
    public void addActorGame(Actor a){
        actors.add(a);
    }

    /**
     * Remove an actor to the game
     * @param a the actor e want to remove
     */
    public void removeActorGame(Actor a){
        actors.remove(a);
        if (listSurvivors.contains(a)) {
            listSurvivors.remove(a);
            return;
        }
        if(listZombies.contains(a)){
            listZombies.remove(a);
        }
    }

    /**
     * Remove all the dead ones
     */
    public void removeDeadActors(){
        for (Actor a : actors)
            if (!a.isAlive())
                this.removeActorGame(a);
    }

    /**
     * Retrives the Global XP of the survivors
     * @return the global xp of the survivors
     */
    public int getGlobalXP(){
        int cpt =0;
        for (Survivor s : listSurvivors)
            cpt+= s.getXP();
        return cpt;
    }

    /**
     * Tells if the game is finished or not
     * @return true if the game is finished
     */
    public boolean isFinished(){
        for(Survivor s : listSurvivors)
            if(s.isAlive())
                return false;
        for(Zombie z : listZombies)
            if(z.isAlive())
                return false;
        if (getGlobalXP() == MAX_GLOBAL_XP)
            return true;

        return true;
    }

    /**
     * Method to set all cells at 0 noise
     */
    public void NoiseDown(){
        for (int w = 0; w < map.getWidth(); w++) {
            for (int h = 0; h < map.getHeight(); h++) {
                map.getCell(new Position(w,h)).shutDownNoise();
            }
        }

    }
    /**
     * Reset all the actionPoint of survivors.(According to the current level of the survivors)
     */
    public void SetActionPointSurvivor(){
        for(Survivor s:listSurvivors){
            if(s.getCurrentLevel()== SurvivorsLevel.STARTING_LEVEL){
                s.setActionPoint(3);
            }
            if(s.getCurrentLevel()==SurvivorsLevel.THIRD_LEVEL){
                s.setActionPoint(4);
            }
            if(s.getCurrentLevel()==SurvivorsLevel.SEVENTH_LEVEL){
                s.setActionPoint(5);
            }
            if(s.getCurrentLevel()==SurvivorsLevel.ELEVENTH_LEVEL){
                s.setActionPoint(6);
            }
        }
    }
    /**
     *
     */
    public Cell getRandomNoiseCell(){
        return map.NoisierCell();
    }


    /**
     * Run the game
     */
    public void run() {
        ListChooser<ActionSurvivor> actionSurvivorListChooser = new RandomListChooser<>();
        ListChooser<Callable> choices = new RandomListChooser<>();
        while (isFinished()) {

            for (Survivor s : listSurvivors) {
                while (s.getActionPoint() != 0) {
                    System.out.println(s);

                    ActionSurvivor action = actionSurvivorListChooser.choose("CHOOSE ONE", s.getActions());
                    List<Callable> actionChoises = action.getChoices();
                    Callable choice;
                    if (!actionChoises.isEmpty())
                        choice = choices.choose("WHICH ONE?", actionChoises);
                    else
                        choice = s;
                    s.makeAction(action, choice);
                    System.out.println(s + " just made the action :" + action);
                }

            }

            for (Zombie zombie : listZombies) {
                ActionZombie actionAttack = zombie.getAction(1);
                if (actionAttack.make(zombie.getCell())) {
                    System.out.println("Le zombie a attaque");
                } else {
                    ActionZombie actionMove = zombie.getAction(0);
                    zombie.makeAction(actionMove, this.getRandomNoiseCell());
                    System.out.println(zombie + " has moved.");
                }

            }
            this.removeDeadActors();
            this.NoiseDown();
            this.s

        } //fin du while

    }
}
