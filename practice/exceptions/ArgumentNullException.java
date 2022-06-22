package practice.exceptions;

public class ArgumentNullException extends BankOnlineException{

    public ArgumentNullException() {}

    public ArgumentNullException(String message) {
        super(message);
    }
    
}
