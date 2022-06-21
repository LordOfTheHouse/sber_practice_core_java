package practice.oop_one.task_five;

public class PizzaOrder {

    private String title;
    private enum Size {SMALL, MEDIUM, BIG};
    private Size sizePizza;
    private boolean sauce;
    private String adress;
    private boolean orderAccepted = false;

    public PizzaOrder(String title, boolean sauce, String adress, int sizePizza) {
        this.title = title;
        this.sauce = sauce;
        this.adress = adress;
        if(sizePizza == 1){
            this.sizePizza = Size.SMALL; 
        } else if(sizePizza == 2){
            this.sizePizza = Size.MEDIUM;
        } else{
            this.sizePizza = Size.BIG;
        }
    }

    /*Принимает заказ */
    public void order(){
        if(orderAccepted){
            System.out.println("The order has already been accepted");
        }else{
            orderAccepted = true;
            String sau = (sauce)?"with":"without";
            System.out.println("Order accepted. " + sizePizza + " pizza \"" 
                                + title + "\" " + sau + " sauce to the address "
                                + adress);
        }
    }

    /*Отменяет заказ */
    public void cansel(){
        if(orderAccepted){
            orderAccepted = false;
            System.out.println("Order cancelled");
        }else{
            System.out.println("The order was not accepted");
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSizePizza(int sizePizza) {
        if(sizePizza == 1){
            this.sizePizza = Size.SMALL; 
        } else if(sizePizza == 2){
            this.sizePizza = Size.MEDIUM;
        } else{
            this.sizePizza = Size.BIG;
        }
    }

    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTitle() {
        return title;
    }

    public Size getSizePizza() {
        return sizePizza;
    }

    public boolean isSauce() {
        return sauce;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return "PizzaOrder [adress=" + adress + ", orderAccepted=" + orderAccepted + ", sauce=" + sauce + ", sizePizza="
                + sizePizza + ", title=" + title + "]";
    }
    

}
