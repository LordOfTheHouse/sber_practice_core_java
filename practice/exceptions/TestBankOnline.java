package practice.exceptions;

public class TestBankOnline {
    public static void main(String[] args) {
        BankOnline b = new BankOnline();
        String s = "1111 1111 1111 1117";
        /*Ошибка когда один передаваемый аргумент null
        b.send(s, null);
        */

        /*Ошибка когда когда сумма больше лимита в 50000
        b.send(s, 55000.0);
        */

        /*Ошибка когда сумма отрицательна
        b.send(s, -100.0);
        */

        /*Ошибка когда в номере карты содержаться не только 
        цифры, или количество цифр не равно 16
        b.send(s, null);
        */

        /*Ошибка с переводом на заблокированную карту
        s = "1111 1111 1111 1111";
        */

        // Успешное выполнение
        b.send(s, 25000.0);

    }
    
}
