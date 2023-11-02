package occupationalTherapy.form;

import java.util.List;

public class Star extends Form {
    private Polygon basePolygon;
    private double innerRadius;
    private double outerRadius;
    private List<Triangle> triangles;

    public Star(double innerRadius, double outerRadius) {
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
    }

    @Override
    public String toCSV() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toCSV'");
    }

    @Override
    public double area() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'area'");
    }

    @Override
    public double circumference() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'circumference'");
    }
}
