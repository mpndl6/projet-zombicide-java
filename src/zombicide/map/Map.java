package zombicide.map;

import java.util.*;

import zombicide.map.cell.*;
import zombicide.map.util.*;


public class Map {

protected int width; 
protected int heigth;
protected Cell[][] cells;

/**
 * It creates a Map with width and heigth
 * known at creation 
 * the Map is initialised at creation
 * @param w width of Map
 * @param h heigth of Map
 * of Map
 */
public Map (int w, int h){
    this.width = w;
    this.heigth= h;
    divideMapVertically(w,h);
}

/**
 * @return heigth ofmap 
 */
public int getheigth(){
    return this.heigth;
}

/**
 * @return width ofmap 
 */
public int getWidth(){
    return this.heigth;
}




public void display() {
    for(int i = 0; i < this.cells.length; i++) {
        for(int j = 0; i < this.cells[0].length; j++) {
            if(this.cells[i][j] instanceof Room)
                if(j < this.cells[0].length - 1)
                    System.out.print(" R  ");
                else
                    System.out.println(" R  ");
            if(this.cells[i][j] instanceof Street)
                if(j < this.cells[0].length - 1)
                    System.out.print(" S  ");
                else
                    System.out.println(" S  ");
            if(this.cells[i][j] instanceof Continental)
                if(j < this.cells[0].length - 1);
                    System.out.print(" RC ");
                else
                    System.out.println(" RC ");
            if(this.cells[i][j] instanceof StreetWW)
                if(j < this.cells[0].length - 1);
                    System.out.print(" SW ");
                else
                    System.out.println(" SW ");
            if(this.cells[i][j] instanceof DrugStore)
                if(j < this.cells[0].length - 1);
                    System.out.print(" RD ");
                else
                    System.out.println(" RD ");
        }
    }
}

}
