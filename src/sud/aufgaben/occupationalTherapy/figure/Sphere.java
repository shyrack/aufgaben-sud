package sud.aufgaben.occupationalTherapy.figure;

public class Sphere extends Figure {

    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public double getSurface() {
        return 4 * Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getVolume() {
        return 4d / 3 * Math.PI * Math.pow(this.radius, 2);
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be a positive double.");
        }
    }

}
