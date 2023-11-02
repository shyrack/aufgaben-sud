package mitarbeiter;

public class Manager extends BueroArbeiter {

	private double bonusSatz;

	public Manager(Manager original) {
		super(original);
		bonusSatz = original.getBonus();
	}

	public Manager(int id, String name, double festgehalt, double bonus) throws IllegalArgumentException{
		// Die Manager-IDs fangen alle mit 50 an
		super(/*Math.abs(id) % 100 + 5000*/id, name, festgehalt);
		setBonus(bonus);
	}

	public double getBonus() {
		return bonusSatz;
	}

	public void setBonus(double bonusSatz) {
		// Der Bonus liegt zwischen 1 und 200%
		if (bonusSatz > 0 && bonusSatz <= 2)
			this.bonusSatz = bonusSatz;
		else
			this.bonusSatz = 0;
	}

	protected void setID(int id) {
		super.setID(Math.abs(id) % 100 + 5000);
	}

	public double berechneBonus() {
		return getFestgehalt() * bonusSatz;
	}

	public double einkommen() {
		return getFestgehalt() + berechneBonus();
	}

	public String toString() {
		return super.toString() + " zuzüglich  Bonus " + Math.round(berechneBonus()*100)/100.0 + ". Gesamteinkommen: "+ Math.round(einkommen()*100)/100.0  ;
	}
//	public void writeIntoCSV(Path file) {
//		super.writeIntoCSV(file);
//		try (BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.APPEND )) {
//			bw.write(this.bonusSatz +"; ");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Override
	public String toCSVString() {
		String result =	super.toCSVString();
		result += this.bonusSatz +";";
		return result;
	}
	@Override
	protected MitarbeiterTyp getType() {
		return MitarbeiterTyp.MANAGER;
	}
}
