package zombicide.map;

import java.util.Random;

import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;

public class Map {

protected int width; 
protected int heitgh;
protected Cell[][] cells;

/**
 * It creates a Map with width and heitgh known at creation 
 * the Map is initialised at creation
 * @param w width of Map
 * @param h heitgh of Map
 */
public Map (int w, int h){
    this.width = w;
    this.heitgh = h;

    initmap();
}

/*
 * init the map at creation
 * 
 */
private void initmap(){
    int start = 0;
    int end = this.width;
    this.divideMapVertically(start, end);
    end = this.heitgh;
    divideHorizontally(start, end);
}

/**
 * Complementary method 
 * This methode divide a part of the map with on street 
 * @param start the start of the section we want to divide
 * @param end the end of the section we want to divide
 * @return value of the end of the smallest section of Map
 */
protected int divideMapVRecursive (int start, int end){
    int w = end - start;
    int lowerBound = 2;
    int higherBound = w - 2;
    if (w < 4) {
        for (int i = start; i < end; i++) {
            for (int j = 0; j < this.height; j++) {
                this.cells[i][j] = new Room();
            }
        } // fill cells of room
    } 
    else {
        int place = random.nextInt(higherBound - lowerBound) + lowerBound; // random between higherBound and lowerBound 
        end = place;
        for (int j=0; j<this.heitgh; j++){
            this.cells[place][j] = new Street();
        }
        this.divideMapVRecursive (start,end);
        }
    return end;
    
}
/**
 * This methode divide Map in Room with Street in between
 * @param start start of Map 
 * @param end end of Map
 */
private void divideMapVertically(int start, int end) {
    int maximum = this.width - 4;
    end = this.width;
    while (start < maximum) {
        start = this.divideMapVRecursive (start,end);
    }
}



}
