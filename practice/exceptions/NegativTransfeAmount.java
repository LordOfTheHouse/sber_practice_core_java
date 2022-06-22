package practice.exceptions;

public class NegativTransfeAmount extends BankOnlineException{

    public NegativTransfeAmount() {}

    public NegativTransfeAmount(String message) {
        super(message);
    }
    
}
