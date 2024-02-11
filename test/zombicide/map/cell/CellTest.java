package zombicide.map.cell;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import zombicide.actor.survivors.Survivor;
import zombicide.actor.zombies.Zombie;
import zombicide.map.util.Position;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CellTest {
    private Cell cell;

    @Before

    public void setUp() {
        cell=new concreteCell(new Position(0,0));
    }

    @Test
    public void testWelcomeZombies(){

        Zombie zombie=new Zombie();
        cell.welcomeZombies(zombie);
        assertEquals(1,cell.howManyZombies());
    }

    @Test
    public void testWelcomeSurvivor(){
        Survivor survivor=new Survivor();
        cell.welcomeSurvivor(survivor);
        assertEquals(1,cell.howManySurvivors());
    }

    @Test
    public void testRemoveZombie(){
        Zombie zombie=new Zombie();
        cell.welcomeZombies(zombie);
        cell.removeZombie(zombie);
        assertEquals(0,cell.howManyZombies());
    }

    @Test
    public void testRemoveSurvivor(){
        Survivor survivor=new Survivor();
        cell.welcomeSurvivor(survivor);
        cell.removeSurvivor(survivor);
        assertEquals(0,cell.howManySurvivors());
    }

    @Test
    public void testGetSurvivors(){
        Survivor survivor=new Survivor();
        cell.welcomeSurvivor(survivor);
        List<Survivor> survivors= cell.getSurvivors();
        assertTrue(survivors.contains(survivor));
    }

    @Test
    public void testGetZombies(){
        Zombie zombie=new Zombie();
        cell.welcomeZombies(zombie);
        List<Zombie> zombies=cell.getZombies();
        assertTrue(zombies.contains(zombie));
    }

    @Test
    public void testCanFight(){
        Survivor survivor=new Survivor();
        cell.welcomeSurvivor(survivor);
        assertTrue(cell.canFight());
    }

    @Test
    public void testDisplay(){
        String display=cell.display();
        assertNotNull(display);
        assertFalse(display.isEmpty());
    }

    @Test
    public void testGetPosition(){
        Position position=cell.getPosition();
        assertNotNull(position);
        assertEquals(0,position.getX());
        assertEquals(0,position.getY());
    }

    @Test
    public void testGetTypeOfCell(){
        assertNotNull(cell.getTypeOfCell());
    }








}



