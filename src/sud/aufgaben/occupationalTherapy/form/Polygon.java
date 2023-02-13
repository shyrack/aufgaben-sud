package sud.aufgaben.occupationalTherapy.form;

public class Polygon extends Form {

    private double radius;
    private int n;

    public Polygon(double radius, int n) {
        this.radius = radius;
        this.n = n;
    }

    @Override
    public double circumference() {
        return this.n * this.getSideLength();
    }

    @Override
    public double area() {
        return this.n * this.radius * this.getSideLength() / 2;
    }

    public int getN() {
        return this.n;
    }

    public double getRadius() {
        return this.radius;
    }

    private double getSideLength() {
        return 2 * this.radius * Math.sin(Math.PI / this.n);
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
