package practice.oop_two;

public class PaintExample {

    public static void main(String[] args) {
        Point p = new Point(5, 10);
        // Тест класса Square
        Square s = new Square(p, 5);
        s.setSide(7);
        s.draw();
        System.out.println(s);

        // Тест класса FigureUtil
        FigureUtil.area(s);
        FigureUtil.perimeter(s);
        FigureUtil.draw(s);
        FigureUtil.draw(s, Color.BLUE);

        //Тест класса Rectangle
        Rectangle r = new Rectangle(p, 5, 10);
        r.setWidth(7);
        r.setHeight(5);
        r.draw(Color.GREEN);
        System.out.println(r);

        //Тест класса Triangle
        Triangle t = new Triangle(p, 3, 10, 5);
        t.setSideB(4);
        t.draw();
        System.out.println(t);

        //Тест класса Circle
        Circle c = new Circle(p, 5);
        c.setRadius(6);
        c.draw(Color.PURPLE);
        System.out.println(c);
    }

}
