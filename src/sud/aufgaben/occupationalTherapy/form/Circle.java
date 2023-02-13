package sud.aufgaben.occupationalTherapy.form;

public class Circle extends Form {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
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
        this.radius = radius;
    }

}
