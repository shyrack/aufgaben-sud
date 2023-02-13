package sud.aufgaben.occupationalTherapy.form;

public class Polygon extends Form {

    private double radius;
    private int n;

    public Polygon(double radius, int n) {
        this.setRadius(radius);
        this.setN(n);
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
        if (n > 2) {
            this.n = n;
        } else {
            throw new IllegalArgumentException("n must be a integer greater than 2.");
        }
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be a positive double.");
        }
    }

}
