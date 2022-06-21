package practice.oop_one.task_two;

public class TestCircle {
    public static void main(String[] args) {
        Circle circ = new Circle(12.5 , "White");
        System.out.println("Area=" + circ.area() + 
                            ", Perimeter=" + circ.perimeter());
        System.out.println(circ);
    }
}
