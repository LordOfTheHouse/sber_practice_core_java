package practice.oop_two;

public abstract class Figure implements Drawable{

    private Point p;
    private String name;

    public Figure(Point p, String name) {
        this.p = p;
        this.name = name;
    }
    
    public abstract double area();
    public abstract double perimeter();

    @Override
    public void draw() {
        System.out.println("A " + name + " with coordinates is drawn " + getP());
    }

    @Override
    public void draw(Color color) {
        System.out.println("A " + color + " " + name + " with coordinates is drawn " + getP());
    }

    public void setP(Point p) {
            this.p = p;
        }

    public Point getP() {
        return p;
    }

    @Override
    public String toString() {
        return "Figure [name=" + name + ", p=" + p + ", area= " 
                + area() + ", perimeter= " + perimeter() + "]";
    }

}
