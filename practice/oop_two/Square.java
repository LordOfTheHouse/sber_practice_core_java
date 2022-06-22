package practice.oop_two;

public class Square extends Rectangle {

    private double side;

    public Square(Point p, double side) {
            super(p, side, side);
        }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
        super.setHeight(side);
        super.setWidth(side);
    }

}
