package sud.aufgaben.occupationalTherapy.container.kfz;

import sud.aufgaben.occupationalTherapy.container.mitarbeiter.Fahrer;
import sud.aufgaben.occupationalTherapy.container.utilities.GPS;

public class Lkw extends Kfz {

    private double ladeFlaeche;
    private double ladung;

    public Lkw(double tankGroesse, GPS aktuellePosition, double ladeFlaeche) {
        // Konstruktor Basis immer an erster Stelle
        super(tankGroesse, aktuellePosition);
        setLadeFlaeche(ladeFlaeche);
        setLadung(0);
    }

    public double getLadeFlaeche() {
        return this.ladeFlaeche;
    }

    public void setLadeFlaeche(double ladeFlaeche) {
        if (ladeFlaeche < 0) {
            // Da wir dem Aufrufer nicht über den Rückgabewert informieren, ob die Operation geklappt hat, werfen
            // wir eine Exception.
            throw new IllegalArgumentException("Eine negative Ladefläche ist nicht möglich!");
        } else if (ladeFlaeche < this.getLadung()) {
            throw new IllegalArgumentException("Die neue Ladefläche soll kleiner sein als die" +
                    "aktuelle Ladung. Bitte entlade zunächst den LKW ausreichend, bevor du die Ladefläche verringerst!"
            );
        } else {
            this.ladeFlaeche = ladeFlaeche;
        }
    }

    public double getLadung() {
        return this.ladung;
    }

    public void setLadung(double ladung) {
        if (ladung > this.getLadeFlaeche()) {
            throw new IllegalArgumentException("Geht nicht. LadeFlaeche zu klein");
        } else if (ladung < 0) {
            throw new IllegalArgumentException("Geht nicht. Negative Ladung nicht möglich.");
        } else {
            this.ladung = ladung;
        }
    }

    public void beladen(double zuLadung) {
        if (this.getLadung() + zuLadung > this.getLadeFlaeche()) {
            throw new IllegalArgumentException("Zuladung nicht möglich, da die freie Ladefläche " +
                    "dafür nicht ausreicht.");
        } else {
            this.setLadung(this.getLadung() + zuLadung);
        }
    }

    /**
     * Entläd die angegebene Menge Ladung vom LKW.
     * Wenn mehr entladen werden soll, als geladen ist, wird einfach alles entladen.
     */
    public void entladen(double entLadung) {
        if (entLadung < 0) {
            throw new IllegalArgumentException("Die Entladung einer negativen Menge ist unmöglich");
        } else if (this.getLadung() < entLadung) {
            // Selten können wir auch eine illegitime Eingabe verwerten (hier: Ladung = 0), indem wir sie bearbeiten.
            // Das muss aber dann Sinn machen und in der Methoden-Dokumentation explizit erwähnt werden.
            System.out.println("Entladewunsch ist größer als die aktuelle Ladung. " +
                    "Wir entladen alles was möglich ist.");  // Man könnte auch eine Exception schmeißen.
            this.setLadung(0);
        } else {
            this.setLadung(this.getLadung() - entLadung);
        }
    }

    public double auslastung() {
        return this.getLadung() / this.getLadeFlaeche();
    }

    @Override
    public boolean einsteigenFahrer(Fahrer fahrer) {
        if (!fahrer.getFuehrerSchein().equals("C")) {
            // Da wir hier den Aufrufer über den Rückgabewert über den illegitimen Parameterwert informieren,
            // müssen wir keine Exception schmeißen.
            System.out.println("Ein LKW-Fahrer braucht einen Führerschein der Klasse C!");
            return false;
        } else {
            return super.einsteigenFahrer(fahrer);
        }
    }

}
