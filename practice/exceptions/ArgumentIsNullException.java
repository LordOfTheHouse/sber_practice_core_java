package practice.exceptions;

public class ArgumentIsNullException extends BankOnlineException{

    public ArgumentIsNullException() {}

    public ArgumentIsNullException(String message) {
        super(message);
    }
    
}
