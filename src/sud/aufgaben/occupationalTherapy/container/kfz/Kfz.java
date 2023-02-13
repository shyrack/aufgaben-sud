package sud.aufgaben.occupationalTherapy.container.kfz;

import sud.aufgaben.occupationalTherapy.container.mitarbeiter.Fahrer;
import sud.aufgaben.occupationalTherapy.container.utilities.GPS;

public abstract class Kfz implements Comparable<Kfz> {
    private double tankGroesse;
    private double tankInhalt = 0;
    private Fahrer fahrer = null; // einsteigenFahrer und parken verändern diese Eigenschaft
    private boolean motorAn = false; // siehe Fahrer
    private GPS aktuellePosition;//
    private double speed = 0;

    // In der Musterlösung wird nur die Tankgrösse und Startposition gesetzt, andere Größen sind 0
    // Einen Default-Konstruktor soll es nicht geben
    public Kfz(double tankGroesse, GPS aktuellePosition) {
        setTankGroesse(tankGroesse);
        this.aktuellePosition = aktuellePosition;
    }

    public double getTankGroesse() {
        return tankGroesse;
    }

    public void setTankGroesse(double tankGroesse) throws IllegalArgumentException {
        if (tankGroesse > 0) {
            this.tankGroesse = tankGroesse;
        } else {
            throw new IllegalArgumentException(tankGroesse + " Tankgroesse (<0) unzulässig");
        }
    }

    public double getTankInhalt() {
        return tankInhalt;
    }
    /*
     * Folgende setter-Methode brauchen wir nicht, da die tanken-Methode das abdeckt
     *
     * public void setTankInhalt(double tankInhalt) {
     *   if (tankInhalt <= this.tankGroesse && tankInhalt >= 0) {
     *     this.tankInhalt = tankInhalt;
     *   } else {
     *     throw new IllegalArgumentException("Passt nicht in Tank.");
     *   }
     * }
     */

    public void fahreZu(GPS ziel) {
        if (this.fahrer == null) {
            System.out.println("Fahrer fehlt. Kann nicht losfahren");
        } else if (this.tankInhalt <= 0) {
            System.out.println("Tank ist leer. Kann nicht losfahren");
        } else {
            // Normaler Ablauf:
            if (!this.isMotorAn()) {
                schalteMotorAn();
            }

            System.out.println(
                    "Route führt von " + this.aktuellePosition.toString()
                            + " zu " + ziel.toString() + "."
            );
            this.aktuellePosition = ziel;
        }
    }

    public Fahrer getFahrer() {
        return fahrer;
    }

    public GPS getAktuellePosition() {
        return aktuellePosition;
    }

    //-----------Besprechung
    public double tanken(double liter) {
        double ueberlauf = 0; //  wegen der Lesbarkeit

        if (liter <= 0) {
            throw new IllegalArgumentException("Für den Tankvorgang wurde ein negatives Zu-Tank-Volumen angegeben.");
        } else {
            if (tankInhalt + liter <= this.tankGroesse) {
                this.tankInhalt = tankInhalt + liter;
            } else {
                System.out.println("Beim Überlaufen abgebrochen. Tank ist maximal gefüllt");
                this.tankInhalt = this.tankGroesse;
                ueberlauf = this.tankInhalt + liter - this.tankGroesse;
            }
        }

        return ueberlauf;
    }

    public boolean einsteigenFahrer(Fahrer fahrer) {
        if (this.fahrer == null) {
            this.fahrer = fahrer;
            return true;
        } else {
            System.out.println("Es sitzt bereits jemand auf dem Fahrersitz!");
            return false;
        }
    }

    public boolean aussteigenFahrer() {
        if (this.fahrer == null) {
            System.out.println("Es gibt keinen Fahrer, der aussteigen könnte");
            return false;
        } else {
            this.fahrer = null;
            return true;
        }
    }

    public void parken() {
        schalteMotorAus();
        this.fahrer = null;
    }

    public boolean isMotorAn() {
        return this.motorAn;
    }

    public void schalteMotorAn() {
        if (isMotorAn()) {
            System.out.println("Motor war schon an");
        } else {
            System.out.println("Zündschlüssel gedreht - brumm.");
            this.motorAn = true;
        }
    }

    public void schalteMotorAus() {
        if (!isMotorAn()) {
            System.out.println("Motor war schon aus.");
        } else {
            this.motorAn = false;
        }
    }

    @Override
    public int compareTo(Kfz kfz) {
        return Double.compare(this.auslastung(), kfz.auslastung());
    }

    public abstract double auslastung();

}
