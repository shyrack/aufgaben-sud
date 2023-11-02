package mitarbeiter;

public class Fahrer extends SchichtArbeiter {
	private String fuehrerSchein;
	private static String[] gueltigeKlassen= {"B","C","D"};

	public String getFuehrerSchein() {
		return fuehrerSchein;
	}

	public void setFuehrerSchein(String fuehrerSchein) {
		boolean gueltig =false;
		for(int i =0; i< gueltigeKlassen.length;i++) {
			if(gueltigeKlassen[i].equals(fuehrerSchein) ) {
				this.fuehrerSchein = fuehrerSchein;
				gueltig=true;
			}
		}
		if(!gueltig)
			throw new IllegalArgumentException( fuehrerSchein + "-Klasse nicht gültig.");
	}

	public Fahrer(int id, String name, double satz, String fuehrerSchein) throws IllegalArgumentException {
		super(id, name, satz);
		this.setFuehrerSchein(fuehrerSchein);
	}
	public String toString() {
		return super.toString() + " hat Führerscheinklasse " + this.fuehrerSchein;
	}
//	public void writeIntoCSV(Path file) {
//		super.writeIntoCSV(file);
//		try (BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.APPEND )) {
//			bw.write(this.fuehrerSchein +"; ");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	@Override
	public String toCSVString() {
		String result =	super.toCSVString();
		result += this.fuehrerSchein +";";
		return result;
	}
	@Override
	protected MitarbeiterTyp getType() {
		return MitarbeiterTyp.FAHRER;
	}
}
