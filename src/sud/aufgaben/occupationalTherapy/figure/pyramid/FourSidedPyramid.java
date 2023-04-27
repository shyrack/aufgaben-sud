package sud.aufgaben.occupationalTherapy.figure.pyramid;

import sud.aufgaben.occupationalTherapy.form.Rectangle;
import sud.aufgaben.occupationalTherapy.form.Triangle;

public class FourSidedPyramid extends PyramidalFigure<Rectangle> {
    public FourSidedPyramid(Rectangle base, double height) {
        super(base, height);
    }

    @Override
    public double lateralHeight() {
        double d = Math.sqrt(Math.pow(super.getBase().getA(), 2) + Math.pow(super.getBase().getB(), 2));
        return Math.sqrt(Math.pow(super.getHeight(), 2) + Math.pow(d / 2, 2));
    }

    @Override
    public double lateralSurface() {
        double lateralHeight = this.lateralHeight();
        return 2 * Triangle.area(lateralHeight, lateralHeight, super.getBase().getA()) + 2 * Triangle.area(lateralHeight, lateralHeight, super.getBase().getB());
    }
}
