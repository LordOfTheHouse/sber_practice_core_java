package practice.exceptions;

public class InvalidNumberCardException extends BankOnlineException {

    public InvalidNumberCardException() {
    }

    public InvalidNumberCardException(String message) {
        super(message);
    }

}
