package practice.exceptions;

public class TransferBlockedCard extends BankOnlineException{

    public TransferBlockedCard() {}

    public TransferBlockedCard(String message) {
        super(message);
    }
    
}
