package practice.oop_one.task_one;

class TestPhone{
    public static void main(String[] args) {

        Phone p1 = new Phone();
        Phone p2 = new Phone("Samsung", "+7-(224)-345-64-43");
        Phone p3 = new Phone("iPhone", "+7-(264)-452-45-26", 150);

        p1.receiveCall("Aleksei");
        p2.receiveCall("Oleg", "7-(264)-452-45-26");
        System.out.println(p2.getNumber());
        Phone.sendMessage();
        System.out.println(p3);


    }
}