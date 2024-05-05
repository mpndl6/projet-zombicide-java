package zombicide;

import grid.Grid;
import listchooser.InteractiveListChooser;
import listchooser.ListChooser;
import listchooser.RandomListChooser;
import zombicide.action.Action;
import zombicide.action.actionSurvivor.*;
import zombicide.action.actionZombie.ActionZombie;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.survivor.SurvivorsLevel;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.ZombieType;
import zombicide.callable.Callable;
import zombicide.item.Item;
import zombicide.item.utility.*;
import zombicide.item.weapon.Pistol;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import javax.rmi.ssl.SslRMIClientSocketFactory;
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
    protected Grid grid;

    /**
     * Construct a new game with  map at construction
     * @param map the map of the game
     */
    public Game(Map map) {
        this.listSurvivors = new ArrayList<>();
        this.listZombies = new ArrayList<>();
        this.actors = new ArrayList<>();
        this.grid = new Grid(map, 7);
        this.map = map;
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
            zombie.setGame(this);
            this.map.putActorONCell(zombie,location);
        System.out.println(n+" Zombies have spawned.\n");
        }
    }

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
        s.setGame(this);
        this.map.putActorONCell(s,map.getCrossRoad());
    }

    /**
     * Set a map to the game
     * @param map the map to set
     */
    public void setMap(Map map){
        this.map = map;
    }

    /**
     * Init All the actions of a survivor
     */
    protected void initActionOfSurvivors(){
        for (Survivor s : listSurvivors) {
            ActionSurvivor move = new MoveAside(s);
            ActionSurvivor open = new OpenDoor(s, this.map);
            ActionSurvivor search = new Search(s);
            ActionSurvivor take = new TakeInHand(s);
            ActionSurvivor use = new UseItem(s);
            ActionSurvivor attack = new AttackSurvivor(s);
            ActionSurvivor look = new LookAround(s);
            ActionSurvivor makeNoise = new MakeNoise(s);
            ActionSurvivor getStatus = new GetStatus(s);

            s.addAction(move);
            s.addAction(open);
            s.addAction(search);
            s.addAction(take);
            s.addAction(use);
            s.addAction(attack);
            s.addAction(look);
            s.addAction(makeNoise);
            s.addAction(getStatus);
        }
    }

    /**
     * Add a zombie to the game
     * @param z the zombie we want to add
     */
    public void addZombieGame(Zombie z){
        listZombies.add(z);
        actors.add(z);
        z.setGame(this);
    }

    /**
     * Add an actor to the game
     * @param a the actor we want to add
     */
    public void addActorGame(Actor a){
        actors.add(a);
        a.setGame(this);
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
    public void removeDeadActors() {
        Iterator<Actor> iterator = actors.iterator();
        while (iterator.hasNext()) {
            Actor actor = iterator.next();
            if (!actor.isAlive()) {
                iterator.remove();
                actor.getCell().removeActor(actor);// supp l'acteur mort
                actor.setGame(null);
                actors.remove(actor);
                if (actor instanceof Survivor) {
                    listSurvivors.remove(actor);
                } else if (actor instanceof Zombie) {
                    listZombies.remove(actor);
                }
            }
        }
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
    public boolean isFinished() {
        boolean allSurvivorsDead = true;
        boolean allZombiesDead = true;
        for (Survivor s : listSurvivors) {
            if (s.isAlive()) {
                allSurvivorsDead = false;
                break;
            }
        }
        for (Zombie z : listZombies) {
            if (z.isAlive()) {
                allZombiesDead = false;
                break;
            }
        }
        boolean globalXPReached = (getGlobalXP() == MAX_GLOBAL_XP);
        return globalXPReached;
    }

    /**
     * Tells if all the survivors have won the game
     * @return true if the survivors have won
     */
    public boolean survivorsWon(){
        //TODO
        return false;
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
    protected void SetActionPointSurvivor(){
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
     * Method to get a random noisy cell
     * @return a random noisy cell
     */
    public Cell getRandomNoiseCell(){
        return map.NoisierCell();
    }

    protected void spawnRandomItem(int howmany) {
        Random randomX = new Random();
        Random randomY = new Random();
        for (int i = 0; i < 10; i++) {
            map.getCell(new Position(randomX.nextInt(map.getWidth()), randomY.nextInt(map.getHeight()))).addItem(new Vial());
        }
        for (int i = 0; i < 10; i++) {
            map.getCell(new Position(randomX.nextInt(map.getWidth()), randomY.nextInt(map.getHeight()))).addItem(new MasterKey(map));
        }
        for (int i = 0; i < 10; i++) {
            map.getCell(new Position(randomX.nextInt(map.getHeight()), randomY.nextInt(map.getHeight()))).addItem(new IRGoogles(map));
        }
        for (int i = 0; i < 10; i++) {
            map.getCell(new Position(randomX.nextInt(map.getWidth()), randomY.nextInt(map.getHeight()))).addItem(new Plan(map));
        }
        for (int i = 0; i < 10; i++) {
            map.getCell(new Position(randomX.nextInt(map.getWidth()), randomY.nextInt(map.getHeight()))).addItem(new FirstAidKit());
        }
    }

    /**
     * Return the nb of zombie needed
     * @return the number of zombie needed
     */
    public int howManyZombiesToGenerate(){
        Random random = new Random();
        int randomZombies;
        int zombiesToGenerate;
        int averageExperience;
        int totalExperience = 0;
        for (Survivor s : listSurvivors){
            totalExperience += s.getXP();
        }
        averageExperience = totalExperience/listSurvivors.size();
        zombiesToGenerate = averageExperience/3;

        return  zombiesToGenerate;
    }

    /**
     * Run the game
     */
    public void run() {
        initActionOfSurvivors();
        spawnRandomItem(10);
        ListChooser<ActionSurvivor> actionSurvivorListChooser = new RandomListChooser<>();
        ListChooser<Callable> choices = new RandomListChooser<>();
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
            System.out.println("___________________________ PHASE DES SURVIVANTS ________________________________ \n");
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
                    System.out.println(s.getNickName() + " just made the action : " + action+"\n\n");
                    else{
                        System.out.println(s.getNickName()+" couldn't do the action : "+action);
                        System.out.println();
                }



            }
            System.out.println("_____________________________________________________________________________________");
          if(!listZombies.isEmpty()){
              System.out.println("_________________________________ PHASE DES ZOMBIES _________________________________ \n");
                for (Zombie zombie : listZombies) {
                    ActionZombie actionAttack = zombie.getAction(1);
                    if (actionAttack.make(zombie.getCell())) {
                        System.out.println(zombie.getNickName()+" attacked\n");
                        grid.displayGrid();
                    }
                    else {
                        ActionZombie actionMove = zombie.getAction(0);
                        boolean move = zombie.makeAction(actionMove, this.getRandomNoiseCell());
                        if (!move) {
                            System.out.println(zombie.getNickName() + " tried to move but has an obstacle.\n");
                            System.out.println(zombie.getNickName() + " at position : " + zombie.getCell().getPosition() + "\n");
                        }
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
