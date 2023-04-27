package sud.aufgaben.occupationalTherapy.figure.pyramid;

import sud.aufgaben.occupationalTherapy.form.Circle;

public class Cone extends PyramidalFigure<Circle> {

    public Cone(Circle base, double height) {
        super(base, height);
    }

    @Override
    public double lateralHeight() {
        return Math.sqrt(Math.pow(super.getHeight(), 2) + Math.pow(super.getBase().getRadius(), 2));
    }

    @Override
    public double lateralSurface() {
        return Math.PI * super.getBase().getRadius() * this.lateralHeight();
    }

    @Override
    public String toCSV() {
        return super.toCSV(this);
    }

}
