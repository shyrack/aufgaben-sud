package sud.aufgaben.occupationalTherapy.a_man_has_fallen_into_a_river;

public class Legostein extends LegoBauteil {
    private String farbe;
    private int groesse;
    private double preis;

    public Legostein(String farbe, int groesse, double preis) {
        this.farbe = farbe;
        this.groesse = groesse;
        this.preis = preis;
    }

    public double preis() {
        return this.preis;
    }
}
