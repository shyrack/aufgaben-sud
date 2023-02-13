package sud.aufgaben.occupationalTherapy.form;

public class Rectangle extends Form {

    private double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return this.a * this.b;
    }

    @Override
    public double circumference() {
        return 2 * this.a + 2 * this.b;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

}
