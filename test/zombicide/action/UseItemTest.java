package zombicide.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zombicide.actor.survivor.Survivor;
import zombicide.item.Item;
import zombicide.item.utility.FirstAidKit;
import zombicide.item.utility.IRGoogles;
import zombicide.item.utility.Plan;
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
}