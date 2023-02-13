package sud.aufgaben.occupationalTherapy.container.utilities;

public class GPS {
    double laengenGrad;
    double breitenGrad;

    public GPS(double laengenGrad, double breitenGrad) throws IllegalArgumentException {
        super();
        this.setLaengenGrad(laengenGrad);
        this.setBreitenGrad(breitenGrad);
    }

    public double getLaengenGrad() {
        return laengenGrad;
    }

    public void setLaengenGrad(double laengenGrad) throws IllegalArgumentException {
        if (laengenGrad > 0 && laengenGrad < 360) {
            this.laengenGrad = laengenGrad;
        } else {
            throw new IllegalArgumentException(laengenGrad + " Längengrad gibt es nicht.");
        }
    }

    public double getBreitenGrad() {
        return breitenGrad;
    }

    public void setBreitenGrad(double breitenGrad) {
        if (breitenGrad > -90 && breitenGrad < 90) {
            this.breitenGrad = breitenGrad;
        } else {
            throw new IllegalArgumentException(breitenGrad + " Breitengrad gibt es nicht.");
        }
    }

    public String toString() {
        return "LxB = (" + this.laengenGrad + ", " + this.breitenGrad + ")";
    }

}
