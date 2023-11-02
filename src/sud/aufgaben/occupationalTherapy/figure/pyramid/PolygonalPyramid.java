package occupationalTherapy.figure.pyramid;

import occupationalTherapy.form.Polygon;
import occupationalTherapy.form.Triangle;

public class PolygonalPyramid extends PyramidalFigure<Polygon> {

    public PolygonalPyramid(Polygon polygon, double height) {
        super(polygon, height);
    }

    @Override
    public double lateralHeight() {
        return Math.sqrt(Math.pow(super.getHeight(), 2) + Math.pow(super.getBase().getOuterRadius(), 2));
    }

    @Override
    public double lateralSurface() {
        double lateralHeight = this.lateralHeight();
        double a = super.getBase().getSideLength();
        Triangle lateralSurfacePiece = new Triangle(lateralHeight, lateralHeight, a);
        return lateralSurfacePiece.area() * super.getBase().getN();
    }

}
