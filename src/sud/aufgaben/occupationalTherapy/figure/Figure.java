package occupationalTherapy.figure;

import occupationalTherapy.CSVWritable;

/**
 * Superclass for the purpose of implementing standardized figure subclasses.
 */
public abstract class Figure implements CSVWritable {

    /**
     * Calculates the surface of the figure.
     *
     * @return Surface of the figure.
     */
    public abstract double surface();

    /**
     * Calculates the volume of the figure.
     *
     * @return Volume of the figure.
     */
    public abstract double volume();

}
