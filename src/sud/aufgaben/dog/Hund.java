package sud.aufgaben.dog;

/**
 * @class Hund
 */
public class Hund {

    private String name;
    private int groesse;
    private double gewicht;
    private String rasse;

    public Hund(String name, String rasse, int groesse, double gewicht) {
        this.setName(name);
        this.setRasse(rasse);
        this.setGroesse(groesse);
        this.setGewicht(gewicht);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        String erlaubt = this.entferneSonderzeichen(name);

        if (erlaubt.length() > 1)
            this.name = erlaubt;
        else {
            System.out.println("Name ist zu kurz!");
        }
    }

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) {
        // Der kleinste Hund ist mindestens 10 cm gro� aber nie groesser als 111cm:
        if (groesse < 10) {
            System.out.println(
                    "So klein ist kein Hund. Der kleinste bekannt Hund war ein Chihuahua Namens Milly und war 9.65 cm hoch.");
            this.groesse = 10;
        } else if (groesse > 111) {
            System.out.println(
                    "So groß ist kein Hund. Der größte bekannte Hund war ein Great Dane Namens Zeus und war 1.118 m gro�.");
            this.groesse = 111;
        } else {
            this.groesse = groesse;
        }
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {

        if (gewicht < 0.5) {
            this.gewicht = 0.5;
            System.out.println(
                    "So wenig wiegt kein erwachsener Hund. Der leichteste Hund hieß Miracle Milly und wo ca. 1 Pfund.");
        } else if (gewicht > 143) {
            this.gewicht = 143;
            System.out.println("So schwer ist kein Hund. Der schwerste bekannte Hund hieß Zorbas und wog 143kg.");
        } else {
            this.gewicht = gewicht;
        }
    }

    public String getRasse() {
        return rasse;
    }

    public void setRasse(String rasse) {

        String erlaubt = this.entferneSonderzeichen(rasse);

        if (erlaubt.length() > 4)
            this.rasse = erlaubt;
        else {
            System.out.println("Die Rasse ist falsch geschrieben!");
        }
    }

    public void ausgabe() {
        System.out.println(this.name + " ist ein Hund der Rasse " + this.rasse + ".");
        System.out.println("Er ist " + this.groesse + " cm groß und wiegt " + this.gewicht + " kg.");
    }

    public void bellen() {
        System.out.println("Wuff wuff");
    }

    public void knurren() {
        System.out.println("GRRRRRR");
    }

    private String entferneSonderzeichen(String text) {

        String erlaubt = "";

        for (int i = 0, j = 0; i < text.length(); i++)
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                if (j == 0)
                    erlaubt += (char) (text.charAt(i) + ('A' - 'a'));//Abstand zwischen A und a als int
                else
                    erlaubt += text.charAt(i);
                j++;
            } else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
                if (j > 0)
                    erlaubt += (char) (text.charAt(i) - ('A' - 'a'));//Abstand zwischen A und a als int
                else
                    erlaubt += text.charAt(i);
                j++;
            }
        return erlaubt;
    }
}
