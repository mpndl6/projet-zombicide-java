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


/**
 * This method returns a int between two numbers
 * @param n first int
 * @param end second int 
 * @return an int between n and m
 */
public int randomIntBetween(int n, int m){
    Random random = new Random();
    return random.nextInt(n - m) + n;
}

/**
 * Complementary method 
 * This methode divide a part of the map with on street 
 * @param start the start of the section we want to divide
 * @param end the end of the section we want to divide
 * @return value of the end of the smallest section of Map
 */
protected int divideMapVRecursive (int start, int end, int lentgh){
    int w = end - start;
    int lowerBound = 2;
    int higherBound = w - 2;
    Random random = new Random();
    if (w < 4) {
        for (int i = start; i < end; i++) {
            for (int j = 0; j < w; j++) {
                this.cells[i][j] = new Room();
            }
        } // fill cells of room
    } 
    else {
        int place = randomIntBetween(lowerBound, higherBound); // random between higherBound and lowerBound 
        end = place;
        for (int j=0; j<lentgh; j++){
            this.cells[place][j] = new Street();
        }
        this.divideMapVRecursive (start,end,lentgh);
        }
    return end;
}

/**
 * Initialise principal road
 */
public void initPrincipalStreet(){
    int randomW = this.randomIntBetween(0,this.width);
    int randomH = this.randomIntBetween(0, this.heitgh);

    for (int i=0; i<this.width;i++){
        this.cells[i][randomH] = new Street();
    }
    for (int i=0; i<this.heitgh;i++){
        this.cells[i][randomW] = new Street();
    }

int XcrossRoad = (randomW + this.width-1)/2;
int YcrossRoad = (randomH + this.heitgh-1)/2;


this.cells[XcrossRoad][YcrossRoad] = new CrossRoad();
this.cells[randomW] = new StreetWithWastewater();
this.cells[randomH] = new StreetWithWastewater();
this.cells[this.width - randomW] = new StreetWithWastewater();
this.cells[this.heitgh - randomH] = new StreetWithWastewater();

}


/*
 * initialize the map at creation
 * 
 */
private void initmap(){
    int randomW = this.randomIntBetween(0,this.width);
    int randomH = this.randomIntBetween(0, this.heitgh);

    for (int i=0; i<this.width;i++){
        this.cells[i][randomH] = new Street();
    }
    for (int i=0; i<this.heitgh;i++){
        this.cells[i][randomW] = new Street();
    }

int XcrossRoad = (randomW + this.width-1)/2;
int YcrossRoad = (randomH + this.heitgh-1)/2;


this.cells[XcrossRoad][YcrossRoad] = new CrossRoad();
this.cells[randomW] = new StreetWithWastewater();
this.cells[randomH] = new StreetWithWastewater();
this.cells[this.width - randomW] = new StreetWithWastewater();
this.cells[this.heitgh - randomH] = new StreetWithWastewater();



divideMapVRecursive(0, randomW, this.width); // 0 to Principal Street (witdh)
divideMapVRecursive(randomW+1, this.width, this.width); // Principal Street to end of Map (width)
divideMapVRecursive(randomH+1, this.heitgh, this.heitgh); // Principal Street to end of Map (heigh)
divideMapVRecursive(0, randomH, this.heitgh); // 0 to Principal Street (heigh)

}

}