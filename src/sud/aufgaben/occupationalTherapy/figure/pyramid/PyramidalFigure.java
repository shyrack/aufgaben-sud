package sud.aufgaben.occupationalTherapy.figure.pyramid;

import sud.aufgaben.occupationalTherapy.figure.BasedFigure;
import sud.aufgaben.occupationalTherapy.form.Form;

/**
 * Superclass for the purpose of implementing standardized figure subclasses with a base.
 *
 * @param <T> Represents the base area of the pyramidal figure.
 */
public abstract class PyramidalFigure<T extends Form> extends BasedFigure<T> {

    public PyramidalFigure(T base, double height) {
        super(base, height);
    }

    @Override
    public double surface() {
        return this.lateralSurface() + super.getBase().area();
    }

    @Override
    public double volume() {
        return (super.getBase().area() * super.getHeight()) / 3;
    }

    /**
     * Calculates the lateral height of the pyramidal figure.
     *
     * @return Lateral height of the figure.
     */
    public abstract double lateralHeight();

    /**
     * Calculates the lateral surface of the pyramidal figure. The base area is not included.
     *
     * @return Lateral surface of the figure.
     */
    public abstract double lateralSurface();

}
