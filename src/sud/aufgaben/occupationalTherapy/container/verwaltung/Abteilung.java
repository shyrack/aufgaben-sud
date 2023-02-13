package sud.aufgaben.occupationalTherapy.container.verwaltung;

import sud.aufgaben.occupationalTherapy.container.mitarbeiter.Manager;
import sud.aufgaben.occupationalTherapy.container.mitarbeiter.Mitarbeiter;

import java.util.Set;
import java.util.TreeSet;

public class Abteilung {
    private String name;
    private Set<Mitarbeiter> mitarbeiter;
    private Manager leiter;

    public Abteilung(String name, Manager leiter) {
        super();
        this.setName(name);
        this.mitarbeiter = new TreeSet<>();
        this.changeLeiter(leiter); // Der Rückgabewert muss hier nicht verwendet werden, weil leiter noch nie gesetzt wurde
    }

    public void add(Mitarbeiter neuer) {
        if (!mitarbeiter.contains(neuer)) {
            mitarbeiter.add(neuer);
        } else {
            System.out.println(neuer.getName() + " arbeitet schon in der Abteilung " + this.getName());
        }
    }

    /**
     * @return ob der Mitarbeiter überhaupt in der Abteilung arbeitete.
     */
    public boolean remove(Mitarbeiter welcher) {
        // Wenn welcher nicht existiert passiert nichts - keine Exception.
        // Der Aufrufer wird trotzdem (durch den Rückgabewert) informiert, ob der Mitarbeiter in der Liste war.
        return mitarbeiter.remove(welcher);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getLeiter() {
        return leiter;
    }

    public Manager changeLeiter(Manager leiter) {
        Manager alter = this.leiter;
        if (mitarbeiter.contains(leiter)) {
            mitarbeiter.remove(leiter);
        }
        this.leiter = leiter;
        return alter;
    }

    public String gehaltsListe() {
        String liste = "Abteilung " + this.name + " geleitet von " + this.leiter.getName() + "\n";
        liste += this.leiter.getName() + ": " + leiter.einkommen() + "\n";

        double summe = leiter.einkommen();
        for (Mitarbeiter m : mitarbeiter) {
            liste += m.getName();
            liste += ": ";
            liste += m.einkommen();
            liste += "\n";
            summe += m.einkommen();
        }
        liste += "Lohnkosten der Abteilung: " + summe + "\n";       // v + 1, weil der Leiter mitgezählt werden muss
        liste += "Durchschnittsgehalt: " + summe / (mitarbeiter.size() + 1);  // und nicht in der mitarbeiter Liste ist.
        return liste;
    }

}
