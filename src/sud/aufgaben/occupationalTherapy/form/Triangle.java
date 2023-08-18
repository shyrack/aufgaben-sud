package sud.aufgaben.occupationalTherapy.form;

import sud.aufgaben.util.HelperFunctions;

public class Triangle extends Form {

    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (Triangle.isTriangle(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            Triangle.throwInvalidTriangleException();
        }
    }

    @Override
    public double circumference() {
        return this.a + this.b + this.c;
    }

    @Override
    public double area() {
        return Triangle.area(this.a, this.b, this.c);
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public void setA(double a) {
        if (Triangle.isTriangle(a, this.b, this.c)) {
            this.a = a;
        } else {
            Triangle.throwInvalidTriangleException();
        }
    }

    public void setB(double b) {
        if (Triangle.isTriangle(this.a, b, this.c)) {
            this.b = b;
        } else {
            Triangle.throwInvalidTriangleException();
        }
    }

    public void setC(double c) {
        if (Triangle.isTriangle(this.a, this.b, c)) {
            this.c = c;
        } else {
            Triangle.throwInvalidTriangleException();
        }
    }

    public static double area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static boolean isTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0;
    }

    public static void throwInvalidTriangleException() {
        throw new IllegalArgumentException("Andre ist ein Dreieck, du Wicht, aber diese Werte sind es nicht.");
    }

    @Override
    public String toCSV() {
        return HelperFunctions.buildCSV(new String[] { this.getClass().getSimpleName(), Double.toString(this.a),
                Double.toString(this.b), Double.toString(this.c) });
    }

}
