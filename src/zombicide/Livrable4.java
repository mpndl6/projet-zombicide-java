package zombicide;

import grid.Grid;
import zombicide.action.Action;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.type.Abomination;
import zombicide.actor.zombie.type.Walker;
import zombicide.map.Map;
import zombicide.map.TrainingMap3;
import zombicide.map.cell.Cell;
import zombicide.map.cell.StreetWW;
import zombicide.map.cell.room.Continental;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.List;

public class Livrable4 {
    public static void main(String[] args) {
        Zombie walker = new Abomination();
        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();
        liststreets.add(new StreetWW());
        listrooms.add(new Continental());


        Map trainningMap = new TrainingMap3(listrooms, liststreets);
        Game game = new Game(trainningMap);
        walker.setGame(game);
        walker.setGame(game);
        game.addZombieGame(walker);

        Grid grid = new Grid(trainningMap, 10);
        grid.displayGrid();
        trainningMap.putActorONCell(walker, new Position(4,2));

        grid.displayGrid();

        Cell cell = trainningMap.getCell(new Position(2,4));
        cell.welcomeActor(new Survivor("jul"));
        cell.makeNoise();
        System.out.println(cell.getNoiseLevel());
        Action moveWalker = walker.getAction(0);
        walker.makeAction(moveWalker, walker);

        grid.displayGrid();
        walker.makeAction(moveWalker, walker);
        grid.displayGrid();
        walker.makeAction(moveWalker, walker);
        grid.displayGrid();
        walker.makeAction(moveWalker, walker);
        grid.displayGrid();
        walker.makeAction(moveWalker, walker);
        grid.displayGrid();
        walker.makeAction(moveWalker, walker);
        grid.displayGrid();
        walker.makeAction(moveWalker, walker);
        grid.displayGrid();
        walker.makeAction(moveWalker, walker);
        grid.displayGrid();
        walker.makeAction(moveWalker, walker);
        grid.displayGrid();
        walker.makeAction(moveWalker, walker);
        grid.displayGrid();


    }

}
