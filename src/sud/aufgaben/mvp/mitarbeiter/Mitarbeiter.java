package mitarbeiter;

public abstract class Mitarbeiter {

	private int id;
	private String name;

	public abstract double einkommen();

	public Mitarbeiter(int id, String name) throws IllegalArgumentException {
		this.setID(id);
		this.setName(name);
	}

	/**
	 * Kopierkonstruktor erstellt einen Klon
	 */
	public Mitarbeiter(Mitarbeiter original) {
		this.name = original.getName();
		this.id = original.getID();
	}

	protected void setID(int id) throws IllegalArgumentException {
		if (id > 999 && id < 10000)
			this.id = id;
		else
			throw new IllegalArgumentException("id ist nicht im gueltigen Bereich");

	}

	public int getID() {
		return this.id;
	}

	public void setName(String name) {
		String erlaubt = "";
		boolean anfangName = true;

		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) >= 'a' && name.charAt(i) <= 'z') {
				if (anfangName) {
					erlaubt += (char) (name.charAt(i) + ('A' - 'a'));
					anfangName = false;
				} else {
					erlaubt += name.charAt(i);
				}
			} else if (name.charAt(i) == ' ') {
				anfangName = true;
				erlaubt += name.charAt(i);
			} else if (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') {
				if (anfangName) {
					erlaubt += name.charAt(i);
					anfangName = false;
				} else {
					erlaubt += (char) (name.charAt(i) - ('A' - 'a'));
				}
			}
		}
		if (erlaubt.length() > 1) {
			this.name = erlaubt;
		} else {
			throw new IllegalArgumentException("Name ist zu kurz oder enthaelt falsche Zeichen");
		}
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return ("\nID: " + id + " Name: " + name);
	}

	protected abstract MitarbeiterTyp getType();

	public String toCSVString() {
		String result = "";
		result += getType() + ";";
		result += this.id + ";";
		result += this.name + ";";
		return result;
	}

}
