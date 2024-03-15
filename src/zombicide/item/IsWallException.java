package zombicide.item;

/**
 * Class IsWallException necessary when an item doest exist
 */
public class IsWallException extends Exception{

    public IsWallException(String message){
        super(message);
    }

    public IsWallException(){
        super();
    }

}
