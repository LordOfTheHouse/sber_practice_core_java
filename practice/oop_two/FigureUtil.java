package practice.oop_two;

public class FigureUtil {

    private FigureUtil(){}
    
    public static void area(Figure figure){
        System.out.println("Area= " + figure.area());
    }

    public static void perimeter(Figure figure){
        System.out.println("Perimeter= " + figure.perimeter());
    }

    public static void draw(Figure figure){
        figure.draw(Color.BLACK);
    }

    public static void draw(Figure figure, Color color){
        figure.draw(color);
    }
    
}
