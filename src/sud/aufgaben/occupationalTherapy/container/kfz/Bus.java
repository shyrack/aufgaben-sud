package sud.aufgaben.occupationalTherapy.container.kfz;

import sud.aufgaben.occupationalTherapy.container.mitarbeiter.Fahrer;
import sud.aufgaben.occupationalTherapy.container.utilities.GPS;

public class Bus extends PersonenTransportFahrzeug {

    public Bus(double tankGroesse, GPS pos, int sitze) {
        super(tankGroesse, pos, sitze);
    }

    @Override
    public boolean einsteigenFahrer(Fahrer fahrer) {
        if (!fahrer.getFuehrerSchein().equals("D")) {
            System.out.println("Ein Busfahrer braucht einen Führerschein der Klasse D!");
            return false;
        } else {
            return super.einsteigenFahrer(fahrer);
        }
    }

}
