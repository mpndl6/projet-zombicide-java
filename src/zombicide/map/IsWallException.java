package zombicide.map;

/**
 * Class IsWallException necessary when a wall is trying to be reach
 */
public class IsWallException extends Exception{

    /**
     * Construct an IsWallException with a message
     * @param message the message of the exception
     */
    public IsWallException(String message){
        super(message);
    }

    /***
     * Construct an IsWallException without a message
     */
    public IsWallException(){
        super();
    }

}
