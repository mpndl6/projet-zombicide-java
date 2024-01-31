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
    //initmap();
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
 * This method returns a random int between two numbers
 * @param n first int
 * @param m second int 
 * @return a random int between n and m
 */
public int randomIntBetween(int n, int m){
    Random random = new Random();
    return random.nextInt(m - n + 1) + n;
}


/**
 * Complementary method 
 * This methode divide a part of the map with on street 
 * @param start the start of the section we want to divide
 * @param end the end of the section we want to divide
 * @return value of the end of the smallest section of Map
 */
protected int divideMapVRecursive (int start, int end, int width, int heigth){
    int w = end - start +1;
    int lowerBound = start +2;
    int higherBound = end - 2; // for the random index
    if (w < 5) {
        for (int i = start; i < end; i++) {
            for (int j = 0; j < heigth; j++) {
                Position p = new Position (i,j);
                if (!(this.cells[i][j] instanceof Street))
                this.cells[i][j] = new Room(p, this.width,this.heigth);
            }
        } // fill cells of room
        return end;
    } 
    else {
        int place = randomIntBetween(lowerBound, higherBound); // random between higherBound and lowerBound 
        for (int j=0; j<heigth; j++){
            Position p = new Position (place,j);
            this.cells[place][j] = new Street(p);
        }
        end = place;
        return this.divideMapVRecursive (start,end,width,heigth);
        }

}


/**
 * Divide the Map in streets vertically
 * @param start the start of the section we want to divide
 * @param end the end of the section we want to divide
 */
protected void divideMapVertically(int start, int end){
    int maximum = this.width -4;
    while (start<maximum){
        int i = divideMapVRecursive(start, end, this.width, this.heigth);
        start = i +1;
    }
    this.divideMapVRecursive(start, end, this.width, this.heigth);
}


/**
 * Divide the Map in streets horizontally
 * @param start the start of the section we want to divide
 * @param end the end of the section we want to divide
 */
protected void divideMapHorizontally(int start, int end){
    int maximum = this.heigth -4;
    while (start<maximum){
        int i = divideMapVRecursive(start, end, this.heigth, this.width);
        start = i+1;
    }
    this.divideMapVRecursive(start, end, this.heigth, this.width);
}


/*
 * initialize the map at creation
 * 
 
protected void initmap(){
    int randomW = this.randomIntBetween(0,this.width);
    int randomH = this.randomIntBetween(0, this.heigth);

    for (int i=0; i<this.width;i++){
        this.cells[randomW][i] = new Street();
    }
    for (int i=0; i<this.heigth;i++){
        this.cells[i][randomH] = new Street();
    }

int XcrossRoad = (randomW + this.width-1)/2;
int YcrossRoad = (randomH + this.heigth-1)/2;


this.cells[XcrossRoad][YcrossRoad] = new CrossRoad();
this.cells[randomW] = new StreetWithWastewater();
this.cells[randomH] = new StreetWithWastewater();
this.cells[this.width - randomW] = new StreetWithWastewater();
this.cells[this.heigth - randomH] = new StreetWithWastewater();


this.divideMapHorizontally(0, randomW); // 0 to Principal Street (witdh)
this.divideMapHorizontally(randomW+1, this.width); // Principal Street to end of Map (width)

this.divideMapVertically(0,randomH); // 0 to Principal Street (heitgh)
this.divideMapVertically(randomH+1,this.heigth); // Principal Street to end of Map (heitgh)


}
*/

}
