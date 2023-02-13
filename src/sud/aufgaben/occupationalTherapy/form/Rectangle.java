package sud.aufgaben.occupationalTherapy.form;

public class Rectangle extends Form {

    private double a, b;

    public Rectangle(double a, double b) {
        this.setA(a);
        this.setB(b);
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
        if (a > 0) {
            this.a = a;
        } else {
            throw new IllegalArgumentException("a must be a positive double.");
        }
    }

    public void setB(double b) {
        if (b > 0) {
            this.b = b;
        } else {
            throw new IllegalArgumentException("b must be a positive double.");
        }
    }

}
