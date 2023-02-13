package sud.aufgaben.occupationalTherapy.container;

import sud.aufgaben.occupationalTherapy.container.mitarbeiter.*;
import sud.aufgaben.occupationalTherapy.container.verwaltung.Abteilung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MitarbeiterMain {

    public static void main(String[] args) {
        // testBasics();
        // testWithAbteilung();
        testSorting();
    }

    public static void testSorting() {
        Manager paula = new Manager(5013, "Paula", 10000, 0.05);
        Manager pia = new Manager(5012, "Pia", 10000, 0.3);
        BueroArbeiter horst = new BueroArbeiter(5213, "Horst", 1300);
        SchichtArbeiter yan = new SchichtArbeiter(3312, "Yan", 15);
        Fahrer fred = new Fahrer(3654, "Fred", 23.5, "C");

        Mitarbeiter[] workerArr = {paula, pia, horst, yan, fred};
        ArrayList<Mitarbeiter> workers = new ArrayList<>(List.of(workerArr));

        System.out.println("Workers unsorted:");
        System.out.println(workers);

        Collections.sort(workers);

        System.out.println();
        System.out.println("Workers sorted:");
        System.out.println(workers);
    }

    public static void testBasics() {
        ArrayList<Mitarbeiter> alleMitarbeiter = new ArrayList<>();

        Manager paula = new Manager(5013, "Paula", 10000, 0.05);
        Manager pia = new Manager(5012, "Pia", 10000, 0.3);
        BueroArbeiter horst = new BueroArbeiter(5213, "Horst", 1300);
        SchichtArbeiter yan = new SchichtArbeiter(3312, "Yan", 15);
        Fahrer fred = new Fahrer(3654, "Fred", 23.5, "C");

        alleMitarbeiter.add(paula);
        alleMitarbeiter.add(pia);
        alleMitarbeiter.add(horst);
        alleMitarbeiter.add(yan);
        alleMitarbeiter.add(fred);

        yan.arbeite(43 * 4);
        fred.arbeite(60 * 4);

        System.out.println("Test toString()");
        for (Mitarbeiter arbeiter : alleMitarbeiter) {
            System.out.println(arbeiter.toString());
        }

        System.out.println("\n\nTest Methode einkommen()");
        double lohnsumme = 0, durchschnitt = 0;
        for (Mitarbeiter m : alleMitarbeiter) {
            lohnsumme += m.einkommen();
            System.out.print(m.getName() + " vom Typ \"");
            System.out.print(m.getClass() + "\" hat ");
            System.out.println("Einkommen: " + m.einkommen());
        }
        durchschnitt = lohnsumme / alleMitarbeiter.size();
        System.out.println("Lohnsumme: " + lohnsumme);
        System.out.println("Durchschnittlicher Lohn: " + durchschnitt);
    }

    public static void testWithAbteilung() {
        Manager paula = new Manager(5013, "Paula", 10000, 0.05);
        Manager pia = new Manager(5076, "Pia", 10000, 0.3);
        BueroArbeiter horst = new BueroArbeiter(5762, "Horst", 1300);
        SchichtArbeiter mal = new SchichtArbeiter(3572, "Yan", 15);
        Fahrer fred = new Fahrer(3333, "Fred", 23.5, "C");

        Abteilung it = new Abteilung("IT-Abteilung", paula);
        it.add(pia);
        it.add(horst);
        it.add(mal);
        it.add(fred);

        mal.arbeite(43 * 4);
        fred.arbeite(60 * 4);

        System.out.println("Test gehaltsListe");
        System.out.println(it.gehaltsListe());
    }

}
