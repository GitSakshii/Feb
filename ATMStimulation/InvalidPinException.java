package ATM_Stimulation;

public class InvalidPinException extends Exception{
    public InvalidPinException(String message){
        super(message);
    }
}