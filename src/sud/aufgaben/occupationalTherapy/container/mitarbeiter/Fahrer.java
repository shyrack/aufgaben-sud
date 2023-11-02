package occupationalTherapy.container.mitarbeiter;

public class Fahrer extends SchichtArbeiter {
    private static String[] gueltigeKlassen = {"B", "C", "D"};
    private String fuehrerSchein;

    public Fahrer(int id, String name, double satz, String fuehrerSchein) throws IllegalArgumentException {
        super(id, name, satz);
        this.setFuehrerSchein(fuehrerSchein);
    }

    public String getFuehrerSchein() {
        return fuehrerSchein;
    }

    public void setFuehrerSchein(String fuehrerSchein) {
        boolean gueltig = false;
        for (int i = 0; i < gueltigeKlassen.length; i++) {
            if (gueltigeKlassen[i].equals(fuehrerSchein)) {
                this.fuehrerSchein = fuehrerSchein;
                gueltig = true;
            }
        }
        if (!gueltig) {
            throw new IllegalArgumentException(fuehrerSchein + "-Klasse nicht gültig.");
        }
    }

    public String toString() {
        return "Fahrer " + super.toString() + " hat Führerscheinklasse " + this.fuehrerSchein;
    }

}
