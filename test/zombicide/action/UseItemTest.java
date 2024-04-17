package zombicide.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.action.actionSurvivor.TakeInHand;
import zombicide.action.actionSurvivor.UseItem;
import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;
import zombicide.item.utility.FirstAidKit;
import zombicide.item.utility.BIGgoogles;
import zombicide.item.utility.IRGoogles;
import zombicide.item.utility.Vial;
import zombicide.map.Map;
import zombicide.map.TrainingMap2;
import zombicide.map.cell.Cell;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UseItemTest {

    Survivor s;
    Item item1;
    Item item2;
    Item item3;
    Item item4;
    UseItem use;
    Map map;

    @BeforeEach
    void setUp() {
        s = new Survivor("Jul");
        item1 = new Vial();
        item2 = new FirstAidKit();
        use = new UseItem(s);
        List<Cell> listRooms = new ArrayList<Cell>();
        List<Cell> listSreet = new ArrayList<Cell>();
        map = new TrainingMap2(listRooms,listSreet);
        item3 = new BIGgoogles(map);
        item4 = new IRGoogles(map);


    }

    @Test
    public void testCanMakeAction() { // survivor can make the action only if they have an item on hand
        assertTrue(use.canMakeAction());
    }

    @Test
    public void testCanNotMakeAction(){
        s.setInHand(null);
        assertFalse(use.canMakeAction());
    }

    @Test
    public void testMakeUseVial() { // on test qu'un item
        //survivor has a pistol on hand, it can open a door
        TakeInHand takeInHand = new TakeInHand(s);
        s.setCell(map.getCell(new Position(3,2)));
        s.makeAction(takeInHand,item1);
        s.makeAction(use, s);
        assertEquals(s.getLifePoints(), 6); // should increase after use

    }

    @Test
    public void testMakeUseFirstAidKit() {
        TakeInHand takeInHand = new TakeInHand(s);
        s.setCell(map.getCell(new Position(3,2)));
        s.makeAction(takeInHand,item2);
        s.makeAction(use,s);
        assertEquals(s.getLifePoints(), 6);

    }

    @Test
    public void testMakeUseBIGgoogles(){
        TakeInHand takeInHand = new TakeInHand(s);
        s.setCell(map.getCell(new Position(3,2)));
        s.makeAction(takeInHand,item3);
        s.makeAction(use,s);
        assertTrue(true);
    }

    @Test
    public void testMakeUseIRGoogles(){
        TakeInHand takeInHand = new TakeInHand(s);
        s.setCell(map.getCell(new Position(3,2)));
        s.makeAction(takeInHand,item4);
        s.makeAction(use,s);
        assertTrue(true);
    }
}