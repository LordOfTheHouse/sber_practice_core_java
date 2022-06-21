package practice.oop_one.task_one;

public class Phone {

    private String number;
    private String model;
    private int weight;

    public Phone(String model, String number, int weight){
        this.model = model;
        this.number = number;
        this.weight = weight;
    }
    
    public Phone(String model, String number){
        this.model = model;
        this.number = number;
        weight = -1;
    }
    
    public Phone(){
        model = "MODEL";
        number = "+7-(***)-***-**-**";
        weight = -1;
    }

    /*Показывает имя звонящего*/
    public void receiveCall(String name){
        System.out.println("Звонит " + name);
    }
    
    /*Показывает имя и номер звонящего*/
    public void receiveCall(String name, String number){
        System.out.println("Звонит " + name);
        System.out.println("Номер " + number);
    }

    /*Выводит номера из массива*/
    public static void sendMessage(){
        String[] numbers = {"+7-(456)-264-73-47", "+7-(245)-264-347-27", 
                            "+7-(153)-647-34-27", "+7-(246)-547-16-48"};

        for(String number: numbers){
            System.out.println(number);
        }

    }

    public String getNumber(){
            return number;
        }

    @Override
    public String toString() {
        return "Phone [model=" + model + ", number=" + number + ", weight=" + weight + "]";
    }

}
