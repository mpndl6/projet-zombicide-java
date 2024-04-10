package zombicide;

import zombicide.actor.survivor.Survivor;
import zombicide.actor.survivor.type.Fighter;
import zombicide.actor.survivor.type.Healer;
import zombicide.actor.survivor.type.Nosy;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.type.Abomination;
import zombicide.actor.zombie.type.Powerful;
import zombicide.actor.zombie.type.Runner;
import zombicide.actor.zombie.type.Walker;
import zombicide.map.Map;
import zombicide.map.TrainingMap3;
import zombicide.map.cell.Cell;
import listchooser.util.*;
import listchooser.*;
import zombicide.map.cell.StreetWW;
import zombicide.map.cell.room.Continental;

import java.util.ArrayList;
import java.util.*;

public class Livrable3 {
    public static void main(String args[]) {
        //actors
        Survivor julien = new Fighter("julien");
        Survivor youssef = new Nosy("Youssef");
        Survivor gabrielle = new Healer("gabrielle");
        Survivor annie = new Survivor("Annie-N");

        Zombie walker = new Walker();
        Zombie runner = new Runner();
        Zombie abomination = new Abomination();
        Zombie powerful = new Powerful();

        //map
        //Add of special room and special street
        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();
        liststreets.add(new StreetWW());
        listrooms.add(new Continental());


        Map trainningMap = new TrainingMap3(listrooms, liststreets);
        // creer la map

        //mettre en main les object à chaue acteur

        // methode MoveAside pour les ZOmbie (on peut utiliser la même ue dans survivor)
        System.out.println("Which action do you want to use?");
        System.out.println("1 - MOVE\n2 - LOOK AROUND\n3 - MAKE NOISE\n4 - OPEN A DOOR\n 5 - SEARCH\n6 - TAKE IN HAND\n7 - USE AN ITEM");

        //listChooser
    }
}
