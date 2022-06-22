package practice.oop_two;

public class Triangle extends Figure{

    private double sideA;
    private double sideB;
    private double sideC;
    
    public Triangle(Point p, double sideA, double sideB, double sideC) {
        super(p, "Triangle");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double halfMeter = perimeter() / 2;
        return Math.sqrt(halfMeter*(halfMeter - sideA)*(halfMeter - sideB)*(halfMeter - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    
    
}
