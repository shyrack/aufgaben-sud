import java.util.ArrayList;

import mitarbeiter.Manager;
import mitarbeiter.Mitarbeiter;

public class Abteilung {
	private String name;
	private ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<>();
	private Manager leiter;

	public Abteilung(String name, Manager leiter) {
		super();
		this.setName(name);
		this.changeLeiter(leiter); //Der R�ckgabewert muss hier nicht verwendet werden, weil leiter noch nie gesetzt wurde
	}

	public void add(Mitarbeiter neuer) {
		if (!mitarbeiter.contains(neuer))
			mitarbeiter.add(neuer);
	}
	public void remove(Mitarbeiter welcher) {
		//wenn welcher nicht existiert passiert nichts - keine Exception
		mitarbeiter.remove(welcher);
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
		if(mitarbeiter.contains(leiter))
			mitarbeiter.remove(leiter);
		this.leiter = leiter;
		return alter;
	}
	public String gehaltsListe() {
		String liste="Abteilung " + this.name + " geleitet von " +this.leiter.getName() +"\n";
		liste += this.leiter.getName() +": "+ leiter.einkommen() +"\n";

		double summe=leiter.einkommen();
		for(Mitarbeiter m : mitarbeiter) {
			liste += m.getName();
			liste += ": ";
			liste += m.einkommen();
			liste +="\n";
			summe+=m.einkommen();
		}
		liste += "Lohnkosten der Abteilung: " + summe;
		liste += "\nDurchschnittsgehalt: " +summe/(mitarbeiter.size()+1);
		return liste;
	}
}
