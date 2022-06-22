package practice.exceptions;

import java.io.*;

public class BankOnline {

    public void send(String cardNumber, Double money){
        try{
            cardNumber = deleteWhitespace(cardNumber);
            if(cardNumber == null || money == null){
                throw new ArgumentIsNullException("The argument is null");
            }else if(money > 50000){
                throw new OutOfLimitTransferException("Exceeded the limit");
            }else if(money < 0){
                throw new NegativeTransferAmountException("The transfer amount " +
                                                        "cannot be a negative number");     
            }else if(!isNumeric(cardNumber) || cardNumber.length() != 16){
                throw new InvalidNumberCardException("Error in writing the card number");
            }else if(isCardBlocked(cardNumber)){
                throw new TransferBlockedCardException("Transfer to a blocked card");
            }
            System.out.println("The operation was successful.");

        }catch(ArgumentIsNullException eNull){
            eNull.printStackTrace();
        }catch(OutOfLimitTransferException eLimit){
            eLimit.printStackTrace();
        }catch(NegativeTransferAmountException eNegative){
            eNegative.printStackTrace();
        }catch(InvalidNumberCardException eNumber){
            eNumber.printStackTrace();
        }catch(TransferBlockedCardException eTransfer){
            eTransfer.printStackTrace();
        }finally{
            System.out.println("Thank you for using our service.");
        }

    }

    /*Проверяет содержит ли номер карты только числа */
    private boolean isNumeric(String str){
        try{
            Double.parseDouble(str);  
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    /*Проверяет относится ли номер карты к заблокированным картам */
    private boolean isCardBlocked(String cardNumber){
        try(BufferedReader br = new BufferedReader(new FileReader("practice\\exceptions\\blockedcard.txt"))){
            String blockedCard;
        while((blockedCard=br.readLine())!=null){     
            blockedCard = deleteWhitespace(blockedCard);  
            if(cardNumber.equals(blockedCard)){
                return true;
            }
        }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    /*Удаляет пробелы из номера карты если такие имеются*/
    private String deleteWhitespace(String str){

        String[] part = str.split(" ");
        String newString = "";

        for(String s: part){
            newString += s;
        }
        return newString;

        }
    

}
