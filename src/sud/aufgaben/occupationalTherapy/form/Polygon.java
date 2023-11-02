package occupationalTherapy.form;

import util.HelperFunctions;

public class Polygon extends Form {

    private double outerRadius;
    private int n;

    public Polygon(double outerRadius, int n) {
        this.setOuterRadius(outerRadius);
        this.setN(n);
    }

    @Override
    public double circumference() {
        return this.n * this.getSideLength();
    }

    @Override
    public double area() {
        return this.n * this.outerRadius * this.getSideLength() / 2;
    }

    public int getN() {
        return this.n;
    }

    public double getOuterRadius() {
        return this.outerRadius;
    }

    public double getSideLength() {
        return 2 * this.outerRadius * Math.sin(Math.PI / this.n);
    }

    public double innerRadius() {
        return this.getSideLength() / (2 * Math.tan(Math.PI / this.n));
    }

    public void setN(int n) {
        if (n > 2) {
            this.n = n;
        } else {
            throw new IllegalArgumentException("n must be a integer greater than 2.");
        }
    }

    public void setOuterRadius(double outerRadius) {
        if (outerRadius > 0) {
            this.outerRadius = outerRadius;
        } else {
            throw new IllegalArgumentException("Radius must be a positive double.");
        }
    }

    @Override
    public String toCSV() {
        return HelperFunctions.buildCSV(new String[] { this.getClass().getSimpleName(), Integer.toString(this.n),
                Double.toString(this.outerRadius) });
    }

}
