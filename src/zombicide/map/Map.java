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

/**
 * Generates a random number within a given range.
 *
 * @param max The maximum value.
 * @param min The minimum value.
 * @return A random number within the specified range.
 */
public int generatNumberForInitmap(int max1 , int min1) {
    int max = max1 - 2;
    int min = min1 + 2;
    int range = max - min + 1;
    int rand = (int)(Math.random() * range) + min;
    return rand;
}


/**
 * Initializes the map with streets.
 *
 * @param wmax The maximum width.
 * @param wmin The minimum width.
 * @param hmax The maximum height.
 * @param hmin The minimum height.
 */
public void initmap(int wmax , int wmin , int hmax , int hmin ) {
    if(wmax - wmin >= 4 && hmax - hmin >= 4) {
        int wl = generatNumberForInitmap(wmax , wmin);
        int hl = generatNumberForInitmap(hmax , hmin);
        for(int j = hmin ; j <= hmax ; j++) {
            this.cells[wl][j] = new Street(new Position(wl,j));
        }
        for(int i = wmin ; i <= wmax ; i++) {
            this.cells[i][hl] = new Street(new Position(i,hl));
        }
        initmap(wmax , wl + 1 , hl -1 , hmin);
        initmap(wmax , wl + 1 , hmax , hl + 1);
        initmap(wl - 1 , wmin , hl -1 , hmin);
        initmap(wl - 1 , wmin , hmax , hl + 1);
    }

    if(wmax - wmin >= 4 && hmax - hmin < 4) {
        int wl = generatNumberForInitmap(wmax , wmin); 
        for(int j = hmin ; j <= hmax ; j++) {
            this.cells[wl][j] = new Street(new Position(wl,j));
        }
        initmap(wmax , wl + 1 , hmax , hmin);
        initmap(wl - 1 , wmin , hmax , hmin);
    }

    if(wmax - wmin < 4 && hmax - hmin >= 4) {
        int hl = generatNumberForInitmap(hmax , hmin);
        for(int i = wmin ; i <= wmax ; i++) {
            this.cells[i][hl] = new Street(new Position(i,hl));
        }
        initmap(wmax , wmin , hl -1 , hmin);
        initmap(wmax , wmin, hmax , hl + 1);
    }
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
