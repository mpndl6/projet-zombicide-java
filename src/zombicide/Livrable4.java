package zombicide;

import grid.Grid;
import zombicide.action.actionZombie.ActionZombie;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.survivor.type.Fighter;
import zombicide.actor.survivor.type.Healer;
import zombicide.actor.survivor.type.Lucky;
import zombicide.actor.survivor.type.Nosy;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.type.Abomination;
import zombicide.map.Map;
import zombicide.map.TrainingMap3;
import zombicide.map.cell.Cell;
import zombicide.map.cell.StreetWW;
import zombicide.map.cell.room.Continental;
import zombicide.map.cell.room.DrugStore;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livrable4 {
    public static void main(String[] args) {
        List<Cell> listrooms = new ArrayList<>();
        List<Cell> liststreets = new ArrayList<>();


        System.out.println("\n\nBIENVENUE SUR LE JEU ZOMBICIDE !!!: \n\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisir le nombre de continental:");
        int nbC = scanner.nextInt();
        for(int i = nbC ; i > 0 ; i--) {
            listrooms.add(new Continental());
        }
        System.out.println("Choisir le nombre de drugStore:");
        int nbD = scanner.nextInt();
        for(int i = nbD ; i > 0 ; i--) {
            listrooms.add(new DrugStore());
        }

        Map trainningMap = new TrainingMap3(listrooms, liststreets);

        System.out.println("Pour Jouer en mode interactif taper 1\nou 2 pour random");
        int choice = scanner.nextInt();

        Game game;
        if (choice == 1) {
            game = new GameInteractive(trainningMap);;
        } else if (choice == 2) {
            game = new Game(trainningMap);
        } else {
            System.out.println("Choix invalide. Utilisation par défaut de GameInteractive.");
            game = new GameInteractive(trainningMap);
        }





        System.out.println(game.getMap());
        game.setMap(trainningMap);

        Survivor gab = new Healer("gab");
        Survivor jul = new Nosy("jul");
        Survivor youss = new Fighter("youss");
        Survivor annie = new Lucky("annie");

        game.addSurvivorGame(gab);
        game.addSurvivorGame(jul);
        game.addSurvivorGame(youss);
        game.addSurvivorGame(annie);

        System.out.println(gab.getGame().isFinished());
        game.run();

    }
}
