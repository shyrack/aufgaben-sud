package sud.aufgaben.occupationalTherapy.container.verwaltung;

import sud.aufgaben.occupationalTherapy.container.kfz.Kfz;
import sud.aufgaben.occupationalTherapy.container.mitarbeiter.Mitarbeiter;
import sud.aufgaben.occupationalTherapy.container.mitarbeiter.SchichtArbeiter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Verwaltung {

    private List<Kfz> fuhrpark;
    private List<Mitarbeiter> personal;
    private List<SchichtArbeiter> arbeiter;
    private List<Abteilung> abteilungen;

    public Verwaltung() {
        this.fuhrpark = new ArrayList<>();
        this.personal = new ArrayList<>();
        this.arbeiter = new LinkedList<>();
        this.abteilungen = new LinkedList<>();
    }

    public void add(Kfz neuesKfz) {
        if (fuhrpark.contains(neuesKfz)) {
            System.out.println("Kfz ist schon Teil des Fuhrparks.");
        } else {
            fuhrpark.add(neuesKfz);
        }
    }

    /**
     * @return ob das Fahrzeug überhaupt schon im Fuhrpark war.
     */
    public boolean remove(Kfz zuEntfernendesKfz) {
        return fuhrpark.remove(zuEntfernendesKfz);
    }

    public void add(Mitarbeiter neuerArbeiter) {
        if (personal.contains(neuerArbeiter)) {
            System.out.println(neuerArbeiter.getName() + " ist bereits als Mitarbeiter eingetragen.");
        } else {
            personal.add(neuerArbeiter);
        }
    }

    /**
     * Entfernt den Mitarbeiter aus der Personalliste. Falls er auch ein Schichtarbeiter ist, dann denke
     * auch daran, ihn mit {@link #remove(SchichtArbeiter)} aus der Schichtarbeiter-Liste zu entfernen!
     *
     * @return ob der Mitarbeiter überhaupt beim Unternehmen angestellt war.
     */
    public boolean remove(Mitarbeiter zuEntlassender) {
        return personal.remove(zuEntlassender);
    }

    /**
     * Fügt den neuen Arbeiter der Schichtarbeiter-Liste hinzu. Falls der Arbeiter noch nicht in der
     * allgemeinen Personalliste ist, wird er auch dort hinzugefügt.
     */
    public void add(SchichtArbeiter neuerArbeiter) {
        arbeiter.add(neuerArbeiter);
        if (!personal.contains(neuerArbeiter)) {
            personal.add(neuerArbeiter);
        }
    }

    /**
     * Entfernt den Schichtarbeiter aus der Schichtarbeiterliste. Falls er komplett entlassen werden soll,
     * dann denke auch daran, ihn mit {@link #remove(Mitarbeiter)} aus der Personal-Liste zu streichen!
     *
     * @return ob der Schichtarbeiter überhaupt beim Unternehmen als Schichtarbeiter angestellt war.
     */
    public boolean remove(SchichtArbeiter zuEntfernender) {
        return arbeiter.remove(zuEntfernender);
    }

    public void add(Abteilung neueAbteilung) {
        abteilungen.add(neueAbteilung);
    }

    /**
     * @return ob die Abteilung überhaupt Teil des Unternehmens war.
     */
    public boolean remove(Abteilung zuEntfernendeAbteilung) {
        return abteilungen.remove(zuEntfernendeAbteilung);
    }

    public void arbeitsTag() {
        for (SchichtArbeiter schichtArbeiter : this.arbeiter) {
            schichtArbeiter.arbeite(8);
        }
    }

}
