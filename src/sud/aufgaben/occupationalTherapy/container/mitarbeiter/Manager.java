package occupationalTherapy.container.mitarbeiter;

public class Manager extends BueroArbeiter {

  private double bonusSatz;

  public Manager(Manager original) {
    // Kopie-Konstruktor. Ruft zunächst den Kopie-Konstruktor von Mitarbeiter auf.
    super(original);
    bonusSatz = original.getBonus();
  }

  public Manager(int id, String name, double festgehalt, double bonus) throws IllegalArgumentException {
    // Konstruktoraufruf super immer an erster Stelle.
    // Der Mitarbeiter-Konstruktor wird die setID Methode von Manager aufrufen und damit überprüfen, ob
    // die ID mit einer 50 beginnt.
    super(id, name, festgehalt);
    setBonus(bonus);
  }

  public double getBonus() {
    return bonusSatz;
  }

  /**
   * @param bonusSatz muss zwischen 0 und 2 (für 200%) liegen.
   */
  public void setBonus(double bonusSatz) {
    // Der Bonus liegt zwischen 0 und 200%
    if (bonusSatz >= 0 && bonusSatz <= 2) {
      this.bonusSatz = bonusSatz;
    } else {
      throw new IllegalArgumentException("Bonus muss zwischen 0 und 200% liegen.");
    }
  }

  /**
   * @param id muss bei Managern mit 50 beginnen. Also zwischen 5000 und 5099 liegen.
   */
  @Override
  protected void setID(int id) {
    if (id >= 5000 && id <= 5099) {
      super.setID(id);
    } else {
      throw new IllegalArgumentException("Manager IDs müssen zwischen 5000 und 5099 liegen");
    }
  }

  public double berechneBonus() {
    return getFestgehalt() * bonusSatz;
  }

  @Override
  public double einkommen() {
    return getFestgehalt() + berechneBonus();
  }

  @Override
  public String toString() {
    return super.toString()
      + " zuzüglich  Bonus " + berechneBonus() + ". "
      + "Gesamteinkommen: " + einkommen();
  }
}
