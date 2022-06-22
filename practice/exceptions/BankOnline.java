package practice.exceptions;

public class BankOnline {
    public void send(String cardNumber, Double money) {
        try{
            if(cardNumber == null || money == null){
                throw new ArgumentIsNullException("The argument is null");
            }
        }catch(ArgumentIsNullException e){
            System.err.println("The argument is null");
        }
    }
}
