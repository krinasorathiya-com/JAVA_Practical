import java.util.Scanner;

abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }

    double area() {
        return 3.14 * r * r;
    }
}

class Rectangle extends Shape {
    double l, w;

    Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    double area() {
        return l * w;
    }
}

class Triangle extends Shape {
    double b, h;

    Triangle(double b, double h) {
        this.b = b;
        this.h = h;
    }

    double area() {
        return 0.5 * b * h;
    }
}

public class ShapeAreaCalculate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter circle radius: ");
        double r = sc.nextDouble();

        System.out.print("Enter rectangle length: ");
        double l = sc.nextDouble();

        System.out.print("Enter rectangle width: ");
        double w = sc.nextDouble();

        System.out.print("Enter triangle base: ");
        double b = sc.nextDouble();

        System.out.print("Enter triangle height: ");
        double h = sc.nextDouble();

        Shape[] shapes = {
            new Circle(r),
            new Rectangle(l, w),
            new Triangle(b, h)
        };

        double total = 0;
        double largest = 0;

        for (Shape s : shapes) {
            double a = s.area();

            System.out.println("Area = " + a);

            total += a;

            if (a > largest) {
                largest = a;
            }
        }

        System.out.println("Total Area = " + total);
        System.out.println("Largest Area = " + largest);

        sc.close();
    }
}