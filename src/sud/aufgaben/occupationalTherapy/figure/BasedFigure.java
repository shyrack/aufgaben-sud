package sud.aufgaben.occupationalTherapy.figure;

import sud.aufgaben.occupationalTherapy.Utils;
import sud.aufgaben.occupationalTherapy.form.Form;

/**
 * Superclass for the purpose of implementing standardized figure subclasses with a base.
 *
 * @param <T> Represents the base area of the figure.
 */
public abstract class BasedFigure<T extends Form> extends Figure {

    private T base;
    private double height;

    /**
     * Constructor of the BasedFigure class
     * @param base Base of the figure
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

    public String toCsvString() {
        return Utils.buildCSV(new String[] {this.getClass().getSimpleName(), "" + this.getHeight(), this.getBase().toCsvString()});
    }
}
