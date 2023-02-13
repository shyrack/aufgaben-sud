package sud.aufgaben.occupationalTherapy.container.mitarbeiter;

public class SchichtArbeiter extends Mitarbeiter {

    private double stundenSatz;
    private int anzahlStunden = 0;

    public SchichtArbeiter(SchichtArbeiter original) {
        // Kopie-Konstruktor. Ruft zunächst den Kopie-Konstruktor von Mitarbeiter auf.
        super(original);
        this.stundenSatz = original.getStundenSatz();
        this.anzahlStunden = original.getAnzahlStunden();
    }

    public SchichtArbeiter(int id, String name, double stundenSatz) throws IllegalArgumentException {
        // Konstruktoraufruf super immer an erster Stelle
        // Der Mitarbeiter-Konstruktor wird die setID Methode von SchichtArbeiter aufrufen und damit überprüfen, ob
        // die ID mit einer 3 beginnt.
        super(id, name);
        setStundenSatz(stundenSatz);
    }

    public double getStundenSatz() {
        return stundenSatz;
    }

    /**
     * @param stundenSatz Muss mindestens dem Mindestlohn (12€) entsprechen.
     * @throws IllegalArgumentException wenn der stundenSatz under dem Mindestlohn liegt.
     */
    public void setStundenSatz(double stundenSatz) throws IllegalArgumentException {
        if (stundenSatz >= 12) {
            this.stundenSatz = stundenSatz;
        } else {
            throw new IllegalArgumentException("Stundensatz liegt unter dem Mindestlohn.");
        }
    }

    public int getAnzahlStunden() {
        return anzahlStunden;
    }

    protected void setAnzahlStunden(int anzahlStunden) {
        if (anzahlStunden >= 0) {
            this.anzahlStunden = anzahlStunden;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void arbeite(int std) {
        if (std > 0) {
            this.setAnzahlStunden(this.anzahlStunden + std);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @param id muss bei Schichtarbeitern mit einer 3 beginnen. Also zwischen 3000 und 3999 liegen.
     */
    @Override
    protected void setID(int id) {
        if (id >= 3000 && id <= 3999) {
            super.setID(id);
        } else {
            throw new IllegalArgumentException("Schichtarbeiter IDs müssen zwischen 3000 und 3999 liegen");
        }
    }

    @Override
    public double einkommen() {
        return anzahlStunden * stundenSatz;
    }

    @Override
    public String toString() {
        return super.toString()
                + " Einkommen: " + einkommen()
                + " bei " + this.getAnzahlStunden() + " gearbeiteten Stunden "
                + "und einem Stundensatz von " + this.getStundenSatz();
    }

}
