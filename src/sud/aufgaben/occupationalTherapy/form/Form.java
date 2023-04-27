package sud.aufgaben.occupationalTherapy.form;

import sud.aufgaben.occupationalTherapy.CSVWritable;

/**
 * Superclass for the purpose of implementing standardized form subclasses.
 */
public abstract class Form implements CSVWritable {

    /**
     * Calculates the area of the form.
     *
     * @return Area of the form.
     */
    public abstract double area();

    /**
     * Calculates the circumference of the form.
     *
     * @return Circumference of the form.
     */
    public abstract double circumference();

}
