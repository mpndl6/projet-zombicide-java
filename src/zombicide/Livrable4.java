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
        Zombie walker = new Abomination();
        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();



        Scanner scanner = new Scanner(System.in);

        System.out.println("choisir le nombre de continantal:");
        int nbC = scanner.nextInt();
        for(int i = nbC ; i > 0 ; i--) {
            listrooms.add(new Continental());
        }
        System.out.println("choisir le nombre de drugStore:");
        int nbD = scanner.nextInt();
        for(int i = nbD ; i > 0 ; i--) {
            listrooms.add(new DrugStore());
        }

        Map trainningMap = new TrainingMap3(listrooms, liststreets);

        System.out.println("Pour Jouer en mode interactif taper 1\nou 2 pour random");
        int choice = scanner.nextInt();

        Game game;
        if (choice == 1) {
            game = new GameInteractive(trainningMap);; // Créez un objet GameInteractive
        } else if (choice == 2) {
            game = new Game(trainningMap); // Créez un objet Game
        } else {
            System.out.println("Choix invalide. Utilisation par défaut de GameInteractive.");
            game = new GameInteractive(trainningMap); // Par défaut, utilisez GameInteractive
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
        System.out.println(game.getMap());

    }
}
