package sud.aufgaben.occupationalTherapy.figure;

import sud.aufgaben.occupationalTherapy.form.Form;

/**
 * Superclass for the purpose of implementing standardized figure subclasses with a base.
 *
 * @param <T> Represents the base area of the figure.
 */
public abstract class BasedFigure<T extends Form> extends Figure {

    private T base;
    private double height;

    public BasedFigure(T base, double height) {
        this.base = base;
        this.height = height;
    }

    public T getBase() {
        return this.base;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public abstract double getSurface();

    @Override
    abstract public double getVolume();

    public void setBase(T base) {
        this.base = base;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
