package sud.aufgaben.occupationalTherapy.figure;

import sud.aufgaben.occupationalTherapy.form.Form;
import sud.aufgaben.util.HelperFunctions;

/**
 * Superclass for the purpose of implementing standardized figure subclasses
 * with a base.
 *
 * @param <T> Represents the base area of the figure.
 */
public abstract class BasedFigure<T extends Form> extends Figure {

    private T base;
    private double height;

    /**
     * Constructor of the BasedFigure class
     * 
     * @param base   Base of the figure
     * @param height Height of the figure
     */
    public BasedFigure(T base, double height) {
        this.setBase(base);
        this.setHeight(height);
    }

    public T getBase() {
        return this.base;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public abstract double surface();

    protected String toCSV(Figure figure) {
        return HelperFunctions.buildCSV(
                new String[] { figure.getClass().getSimpleName(), Double.toString(this.height), this.base.toCSV() });
    }

    @Override
    abstract public double volume();

    public void setBase(T base) {
        this.base = base;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height must be a positive number.");
        }
    }

}
