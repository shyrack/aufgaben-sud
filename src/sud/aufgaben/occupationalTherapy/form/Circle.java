package sud.aufgaben.occupationalTherapy.form;

public class Circle extends Form {

    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
    }

    @Override
    public double area() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    @Override
    public double circumference() {
        return 2 * this.radius * Math.PI;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be a positive double.");
        }
    }

}
