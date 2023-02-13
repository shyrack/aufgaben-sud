package sud.aufgaben.occupationalTherapy.container;

import sud.aufgaben.occupationalTherapy.container.kfz.Bus;
import sud.aufgaben.occupationalTherapy.container.kfz.Kfz;
import sud.aufgaben.occupationalTherapy.container.kfz.Lkw;
import sud.aufgaben.occupationalTherapy.container.kfz.PersonenTransportFahrzeug;
import sud.aufgaben.occupationalTherapy.container.mitarbeiter.Fahrer;
import sud.aufgaben.occupationalTherapy.container.mitarbeiter.SchichtArbeiter;
import sud.aufgaben.occupationalTherapy.container.utilities.GPS;

public class KfzMain {
    public static void main(String[] args) {
        PersonenTransportFahrzeug meinAuto = new PersonenTransportFahrzeug(40, new GPS(40, 40), 5);
        Lkw brummi = new Lkw(80, new GPS(10, 10), 10.0);
        PersonenTransportFahrzeug bulli = new PersonenTransportFahrzeug(50, new GPS(49, 49), 7);
        Bus cruiser = new Bus(250, new GPS(12, 12), 50);

        Kfz[] fahrzeuge = new Kfz[3];
        fahrzeuge[0] = brummi;
        fahrzeuge[1] = bulli;
        fahrzeuge[2] = cruiser;

        System.out.println("Sitze von meinem Auto: " + meinAuto.getSitze()); // geht nicht mit Kfz Referenz
        System.out.println("Auslastung von meinem Auto: " + meinAuto.auslastung());
        System.out.println("Position von meinem Auto: " + meinAuto.getAktuellePosition());
        meinAuto.einsteigenFahrer(new Fahrer(3021, "Ich", 10_000, "C"));
        meinAuto.tanken(12);
        meinAuto.fahreZu(new GPS(15, 88));
        System.out.println("Position von meinem Auto nach der Fahrt: " + meinAuto.getAktuellePosition());

        for (int i = 0; i < fahrzeuge.length; i++) {
            System.out.println("Tankinhalt von " + i + " " + fahrzeuge[i].getTankInhalt());
            System.out.println("Auslastung von " + i + " " + fahrzeuge[i].auslastung());
            System.out.println("Position von " + i + " " + fahrzeuge[i].getAktuellePosition());
        }
        System.out.println("Ladung Lkw " + brummi.getLadung());
        System.out.println("Personen Bus " + cruiser.getPassagiere());

        // PersonenTransportFahrzeug Polymorphie testen. (Wir wissen nur, dass der Bus ein PersTransportFahrzeug ist)
        PersonenTransportFahrzeug ptf = new Bus(123.12, new GPS(12, 12), 50);
        System.out.println("Passagiere im ptf: " + ptf.getPassagiere());
        System.out.println("Sitze vom ptf: " + ptf.getSitze());
        System.out.println("Auslastung vom ptf: " + ptf.auslastung());

        SchichtArbeiter manni = new SchichtArbeiter(3022, "Manni", 13);
        SchichtArbeiter katrin = new SchichtArbeiter(3022, "Katrin", 13);
        ptf.einsteigen(manni);
        ptf.einsteigen(katrin);

        System.out.println("Passagiere im ptf (nach Einsteigen): " + ptf.getPassagiere());
        System.out.println("Sitze vom ptf (nach Einsteigen): " + ptf.getSitze());
        System.out.println("Auslastung vom ptf (nach Einsteigen): " + ptf.auslastung());

        // Im Optimalfall testet man jede Methode.
    }

}
