package sud.aufgaben.occupationalTherapy.figure.pyramid;

import java.util.Arrays;

import sud.aufgaben.occupationalTherapy.form.Triangle;

public class ThreeSidedPyramid extends PyramidalFigure<Triangle> {

    public ThreeSidedPyramid(Triangle base, double height) {
        super(base, height);
    }

    @Override
    public double lateralHeight() {
        double sha = (Math.sqrt(2 * Math.pow(super.getBase().getB(), 2) + 2 * Math.pow(super.getBase().getC(), 2)
                - Math.pow(super.getBase().getA(), 2))) / 2;
        return Math.sqrt(Math.pow(super.getHeight(), 2) + Math.pow(2 * sha, 2));
    }

    @Override
    public double lateralSurface() {
        double[] sides = { super.getBase().getA(), super.getBase().getB(), super.getBase().getC() };
        double lateralHeight = this.lateralHeight();
        return Arrays.stream(sides).map(x -> Triangle.area(lateralHeight, lateralHeight, x)).sum();
    }

    @Override
    public String toCSV() {
        return super.toCSV(this);
    }

}
