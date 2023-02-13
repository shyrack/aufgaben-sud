package sud.aufgaben.occupationalTherapy.container.kfz;

import sud.aufgaben.occupationalTherapy.container.mitarbeiter.Mitarbeiter;
import sud.aufgaben.occupationalTherapy.container.utilities.GPS;

import java.util.*;

public class PersonenTransportFahrzeug extends Kfz {

    // Map<...> ist eine Tabelle die in unserem Fall unter Nummern (Sitznummern)
    //   die Mitarbeiter abspeichert, die dort sitzen.
    private Map<Integer, Mitarbeiter> passagiere = new HashMap<>();
    private int sitze;

    public PersonenTransportFahrzeug(double tankGroesse, GPS aktuellePosition, int sitze) {
        super(tankGroesse, aktuellePosition);
        setSitze(sitze);
    }

    public List<Mitarbeiter> getPassagiere() {
        // Passagiere.values gibt nur die Passagiere (ohne Sitzplatznummer) zurück.
        return new ArrayList<>(passagiere.values());
    }

    public int getSitze() {
        return sitze;
    }

    public void setSitze(int sitze) {
        if (sitze < 0) {
            throw new IllegalArgumentException("Man kann kein Fahrzeug mit negativ vielen Sitzen haben.");
        } else if (sitze < this.getPassagiere().size()) {
            throw new IllegalArgumentException("Du willst so viele Sitze entfernen, dass einige aktuelle " +
                    "Passagiere in der Luft sitzen würden. Lass sie vorher besser aussteigen.");
        } else {
            this.sitze = sitze;
        }
    }

    public boolean einsteigen(Mitarbeiter mitarbeiter) {
        if (passagiere.containsValue(mitarbeiter)) {
            System.out.println("Mitarbeiter sitzt bereits im Auto.");
            return false;
        } else if (passagiere.size() >= sitze) {
            System.out.println("Überfüllung!");
            return false;
        } else {
            passagiere.put(calcFreienSitzplatz(), mitarbeiter);
            return true;
        }
    }

    public Mitarbeiter aussteigen(int vonSitzplatz) {
        if (!passagiere.containsKey(vonSitzplatz)) {
            throw new NoSuchElementException("Auf diesem Platz sitzt niemand.");
        } else {
            return passagiere.remove(vonSitzplatz);
        }
    }

    @Override
    public double auslastung() {
        if (sitze == 0) {
            return 1;
        } else {
            // Wir müssen eine der an der Division beteiligten Ganzzahlen zu einer Kommazahl konvertieren.
            // Sonst wählt Java die Divisions-Logik für Ganzzahlen und rundet Nachkomma-Stellen ab.
            // Also wird aus 0.15 (das 15% repräsentiert) eine 0.
            // Indem wir eine der Zahlen zu einer Kommazahl machen, ändert sich Javas Logik zu einer Kommazahl-Division,
            // die den Rest hinter dem Komma nicht verwirft.
            return this.passagiere.size() / (double) this.sitze;
        }
    }

    @Override
    public void parken() {
        for (int belegterPlatz : passagiere.keySet()) {
            aussteigen(belegterPlatz);
        }
        super.parken();
        /* // Alternative Implementierung für parken():
         * for (int i = 0; i < sitze; i++) {
         *   try {
         *     aussteigen(i);
         *   } catch(IllegalArgumentException) { }
         * }
         * super.parken()
         * // Der Catch-Block ist leer, weil wir die Fälle, in denen der Sitzplatz
         * // leer ist, einfach ignorieren wollen.
         */
    }

    /**
     * Gibt einen freien Sitzplatz zurückgegeben.
     *
     * @throws IllegalStateException wenn alle Sitzplätze belegt sind
     */
    private int calcFreienSitzplatz() throws IllegalStateException {
        if (passagiere.size() >= sitze) {
            throw new IllegalStateException("Auto ist schon voll!");
        } else {
            for (int i = 0; i < sitze; i++) {
                if (!passagiere.containsKey(i)) {  // "Keys" sind die Sitzplätze der passagiere
                    return i;
                }
            }

            // Java versteht von selbst nicht, dass die for-Schleife in jedem Fall eine Zahl zurückgibt.
            // Als Konsequenz erwartet Java noch ein return-statement oder eine Exception. Letztere
            // spiegelt gut wider, dass wir an diese Stelle des Codes gar nicht gelangen dürften.
            throw new IllegalArgumentException();
        }
    }

}
