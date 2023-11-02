package mitarbeiter;

public class SchichtArbeiter extends Mitarbeiter {

	private double stundenSatz;
	private int anzahlStunden = 0;

	public SchichtArbeiter(SchichtArbeiter original) {
		super(original);
		this.stundenSatz = original.getStundenSatz();
		this.anzahlStunden = original.getAnzahlStunden();
	}

	public SchichtArbeiter(int id, String name, double stundenSatz) throws IllegalArgumentException {

		/*
		 * Konstruktoraufruf super immer an erster Stelle
		 */
		super(Math.abs(id) % 1000 + 3000, name);
		setStundenSatz(stundenSatz);
	}

	public double getStundenSatz() {
		return stundenSatz;
	}

	public void setStundenSatz(double stundenSatz) throws IllegalArgumentException {
		if (stundenSatz >= 9.82)
			this.stundenSatz = stundenSatz;
		else
			throw new IllegalArgumentException("Stundensatz zu gering.");
	}

	public int getAnzahlStunden() {
		return anzahlStunden;
	}

	public void setAnzahlStunden(int anzahlStunden) {
		if (anzahlStunden > 0)
			this.anzahlStunden = anzahlStunden;
	}

	public void arbeite(int std) {
		if (std > 0)
			this.setAnzahlStunden(this.anzahlStunden + std);
	}

	protected void setID(int id) {
		super.setID(Math.abs(id) % 1000 + 3000);
	}

	public double einkommen() {
		return anzahlStunden * stundenSatz;
	}

	public String toString() {
		return super.toString()
				+ (" Einkommen: " + einkommen() + " bei " + this.anzahlStunden + " gearbeiteten Stunden.");
	}
//	public void writeIntoCSV(Path file) {
//		super.writeIntoCSV(file);
//		try (BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.APPEND )) {
//			bw.write(this.stundenSatz +"; ");
//			bw.write(this.anzahlStunden +"; ");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Override
	public String toCSVString() {
		String result =	super.toCSVString();
		result += this.stundenSatz +";";
		result += this.anzahlStunden +";";
		return result;
	}
	@Override
	protected MitarbeiterTyp getType() {
		return MitarbeiterTyp.SCHICHT;
	}
}
