package zombicide.actor.survivor;

/** Class FullBackpackException util when an item does not exist in a particular place */
public class FullBackpackException extends Exception{

    /***
     *
     */
    public FullBackpackException (String message){
        super(message);
    }
    public FullBackpackException(){
        super();
    }
}
