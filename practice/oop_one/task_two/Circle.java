package practice.oop_one.task_two;

public class Circle {
    
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    /*Находит площадь круга */
    public double area(){
        return Math.PI * radius * radius;
    }

    /*Находит периметр круга */
    public double perimeter(){
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle [color=" + color + ", radius=" + radius +
                ", area=" + area() + ", perimeter=" + perimeter()+ "]";
    }

}
