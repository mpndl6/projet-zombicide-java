package zombicide.map;

import java.util.*;

import zombicide.map.cell.*;
import zombicide.map.cell.room.*;
import zombicide.map.util.*;


public class MapMain {
    public static void main(String[] args) {
        Map map = new Map(10 , 20);
        map.display();
    } 
} 