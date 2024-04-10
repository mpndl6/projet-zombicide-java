package zombicide.action;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import zombicide.Game;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.type.Runner;
import zombicide.actor.zombie.type.Walker;
import zombicide.callable.Callable;
import zombicide.item.Item;
import zombicide.item.weapon.Carabine;
import zombicide.item.weapon.Weapon;
import zombicide.map.TrainingMap2;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;
import zombicide.map.cell.StreetWW;
import zombicide.map.cell.room.Continental;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.List;



public class AttackSurvivorTest {
    @Test
    public void test_attack_pistol_onSameCell_Successful() {

        Survivor survivor = new Survivor("Survivor1");
        Zombie zombie = new Runner();

        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();
        TrainingMap2 map = new TrainingMap2(listrooms, liststreets);
        map.putActorONCell(survivor, new Position(1, 1));
        map.putActorONCell(zombie, new Position(1, 1));

        Game game = new Game(map);

        survivor.setGame(game);

        AttackSurvivor attack = new AttackSurvivor(survivor);


        boolean result = attack.make(zombie);


        assertTrue(result);
        assertEquals(zombie.getLifePoints(), 1);
    }

    @Test
    public void test_attack_pistol_unSuccessful() {

        Survivor survivor = new Survivor("Survivor1");
        Zombie zombie = new Runner();

        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();
        TrainingMap2 map = new TrainingMap2(listrooms, liststreets);
        map.putActorONCell(survivor, new Position(1, 1));
        map.putActorONCell(zombie, new Position(3, 1));

        Game game = new Game(map);

        survivor.setGame(game);

        AttackSurvivor attack = new AttackSurvivor(survivor);


        boolean result = attack.make(zombie);


        assertFalse(result);
        assertEquals(zombie.getLifePoints(), 2);
    }

    @Test
    public void test_attack_carabine_unSuccessful() {

        Survivor survivor = new Survivor("Survivor1");
        Zombie zombie = new Runner();
        Item carabine = new Carabine();


        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();
        TrainingMap2 map = new TrainingMap2(listrooms, liststreets);
        map.putActorONCell(survivor, new Position(1, 1));
        map.putActorONCell(zombie, new Position(1, 1));
        survivor.getCell().addItem(carabine);
        TakeInHand takeInHand = new TakeInHand(survivor);
        takeInHand.make(carabine);
        Game game = new Game(map);

        survivor.setGame(game);

        AttackSurvivor attack = new AttackSurvivor(survivor);


        boolean result = attack.make(zombie);


        assertFalse(result);
        assertEquals(zombie.getLifePoints(), 2);
    }

    @Test
    public void test_attack_carabine_Successful() {

        Survivor survivor = new Survivor("Survivor1");
        Zombie zombie = new Runner();
        Item carabine = new Carabine();


        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();
        TrainingMap2 map = new TrainingMap2(listrooms, liststreets);
        map.putActorONCell(survivor, new Position(2, 0));
        map.putActorONCell(zombie, new Position(2, 2));
        survivor.getCell().addItem(carabine);
        TakeInHand takeInHand = new TakeInHand(survivor);
        takeInHand.make(carabine);
        Game game = new Game(map);

        survivor.setGame(game);

        AttackSurvivor attack = new AttackSurvivor(survivor);


        boolean result = attack.make(zombie);


        assertTrue(result);
        assertEquals(zombie.getLifePoints(), 1);
    }

}

