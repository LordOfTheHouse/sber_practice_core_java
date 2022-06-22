package practice.oop_two;

public class Rectangle extends Figure{
    
    private double width;
    private double height;
    
    public Rectangle(Point p, double width, double height) {
        super(p, (width == height)?"Square":"Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return (height + width) * 2;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
