import java.lang.Math;

abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }

    double area() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape {
    double l;
    double w;

    Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    double area() {
        return l * w;
    }
}

class Triangle extends Shape {
    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

public class Shapemain {
    public static void main(String[] args) {

        Shape[] s = {
            new Circle(5),
            new Rectangle(4, 3),
            new Triangle(2, 7)
        };

        double total = 0;
        double largest = 0;
        String largestShape = "";

        for (int i = 0; i < s.length; i++) {

            double currentArea = s[i].area();

            System.out.println(
                "Area of " + s[i].getClass().getSimpleName()
                + " is: " + currentArea
            );

            total = total + currentArea;

            if (currentArea > largest) {
                largest = currentArea;
                largestShape = s[i].getClass().getSimpleName();
            }
        }

        System.out.println("----------------------");
        System.out.println("Total area: " + total);
        System.out.println("Largest area: " + largest);
        System.out.println("Largest shape: " + largestShape);
    }
}