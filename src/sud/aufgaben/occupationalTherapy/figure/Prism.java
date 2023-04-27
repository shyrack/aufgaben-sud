package sud.aufgaben.occupationalTherapy.figure;

import sud.aufgaben.occupationalTherapy.form.Form;

public class Prism<T extends Form> extends BasedFigure<T> {

    public Prism(T base, double height) {
        super(base, height);
    }

    public double surface() {
        return 2 * super.getBase().area() + super.getHeight() * super.getBase().circumference();
    }

    public double volume() {
        return super.getBase().area() * super.getHeight();
    }
}
