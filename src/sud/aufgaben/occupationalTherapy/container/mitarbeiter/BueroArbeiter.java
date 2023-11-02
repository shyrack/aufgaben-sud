package occupationalTherapy.container.mitarbeiter;

public class BueroArbeiter extends Mitarbeiter {

  private double festgehalt;

  public BueroArbeiter(BueroArbeiter original) {
    // Kopie-Konstruktor. Ruft zunächst den Kopie-Konstruktor von Mitarbeiter auf.
    super(original);
    festgehalt = original.getFestgehalt();
  }

  public BueroArbeiter(int id, String name, double festgehalt) throws IllegalArgumentException {
    // Konstruktoraufruf super immer an erster Stelle.
    // Der Mitarbeiter-Konstruktor wird die setID Methode von BueroArbeiter aufrufen und damit überprüfen, ob
    // die ID mit einer 5 beginnt.
    super(id, name);
    setFestgehalt(festgehalt);
  }

  public double getFestgehalt() {
    return festgehalt;
  }

  /**
   * @param festgehalt Muss mindestens 300€ sein.
   * @throws IllegalArgumentException wenn das festgehalt under 300€ liegt.
   */
  public void setFestgehalt(double festgehalt) throws IllegalArgumentException {
    if (festgehalt > 300) {
      this.festgehalt = festgehalt;
    } else {
      throw new IllegalArgumentException("Gehalt liegt unter 300€ und ist damit zu gering.");
    }
  }

  public double einkommen() {
    return festgehalt;
  }

  /**
   * @param id muss bei BueroArbeitern mit einer 5 beginnen. Also zwischen 5000 und 5999 liegen.
   */
  protected void setID(int id) {
    if (id >= 5000 && id <= 5999) {
      super.setID(id);
    } else {
      throw new IllegalArgumentException("BueroArbeiter IDs müssen zwischen 5000 und 5999 liegen");
    }
  }

  @Override
  public String toString() {
    return super.toString() + " hat Festgehalt: " + this.festgehalt;
  }
}
