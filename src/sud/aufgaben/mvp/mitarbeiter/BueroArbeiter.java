package mitarbeiter;

public class BueroArbeiter extends Mitarbeiter {

	private double festgehalt;

	public BueroArbeiter(BueroArbeiter original) {
		super(original);
		festgehalt = original.getFestgehalt();
	}

	public BueroArbeiter(int id, String name, double festgehalt) throws IllegalArgumentException {
		super(id, name);
		setFestgehalt(festgehalt);
	}

	public double getFestgehalt() {
		return festgehalt;
	}

	public double einkommen() {
		return festgehalt;
	}

	public void setFestgehalt(double festgehalt) throws IllegalArgumentException {
		if (festgehalt > 300) // Mindestlohn 300 Euro
			this.festgehalt = festgehalt;
		else
			throw new IllegalArgumentException("Gehalt ist zu gering.");
	}

	protected void setID(int id) {
		super.setID(Math.abs(id) % 1000 + 5000);
	}

	public String toString() {
		return super.toString() + " hat Festgehalt: " + this.festgehalt;
	}
	@Override
	public String toCSVString() {
		String result =	super.toCSVString();
		result += this.festgehalt +";";
		return result;
	}

	@Override
	protected MitarbeiterTyp getType() {
		return MitarbeiterTyp.BUERO;
	}
}
