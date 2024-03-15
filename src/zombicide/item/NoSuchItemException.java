package zombicide.item;

/** Class NoSuchItemException util when an item does not exist in a particular place */
public class NoSuchItemException extends Exception{
    public NoSuchItemException (String message){
        super(message);
    }
    public NoSuchItemException(){
        super();
    }
}
