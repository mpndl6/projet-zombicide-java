package zombicide.map;

import java.util.Random;

import zombicide.map.cell.*;

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
    initmap();
}

/**
 * @return heigth ofmap 
 */
public int getheigth(){
    return this.heigth;
}

/**
 * @return heigth ofmap 
 */
public int getWidth(){
    return this.heigth;
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
    int higherBound = w - 2; // for the random index
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
 * 
 * @param start
 * @param end
 */
public void divideMapVertically(int start, int end){
    int maximum = this.width -4;
    while (start<maximum){
        int i = divideMapVRecursive(start, end, this.width);
        start = i +1;
    }
}

/**
 * 
 * @param start
 * @param end
 */
public void divideMapHorizontally(int start, int end){
    int maximum = this.heigth -4;
    while (start<maximum){
        int i = divideMapVRecursive(start, end, this.heigth);
        start = i +1;
    }
}

/*
 * initialize the map at creation
 * 
 */
protected void initmap(){
    int randomW = this.randomIntBetween(0,this.width);
    int randomH = this.randomIntBetween(0, this.heigth);

    for (int i=0; i<this.width;i++){
        this.cells[i][randomH] = new Street();
    }
    for (int i=0; i<this.heigth;i++){
        this.cells[i][randomW] = new Street();
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


}
