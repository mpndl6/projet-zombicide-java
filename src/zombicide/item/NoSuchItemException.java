package zombicide.item;

public class NoSuchItemException extends Exception{
    public NoSuchItemException (String message){
        super(message);
    }
    public NoSuchItemException(){
        super();
    }
}
