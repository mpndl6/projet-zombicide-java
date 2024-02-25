package zombicide.item;

/**
 * Class NoSuchItemException necessary when an item doest exist
 */
public class NoSuchItemException extends Exception{

    public NoSuchItemException (String message){
        super(message);
    }

}
