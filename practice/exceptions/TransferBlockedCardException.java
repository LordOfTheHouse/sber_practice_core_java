package practice.exceptions;

public class TransferBlockedCardException extends BankOnlineException {

    public TransferBlockedCardException() {
    }

    public TransferBlockedCardException(String message) {
        super(message);
    }

}
