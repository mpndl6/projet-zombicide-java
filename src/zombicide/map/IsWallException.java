package zombicide.map;

/**
 * Class IsWallException necessary when a wall is trying to be reach
 */
public class IsWallException extends Exception{

    public IsWallException(String message){
        super(message);
    }

    public IsWallException(){
        super();
    }

}
