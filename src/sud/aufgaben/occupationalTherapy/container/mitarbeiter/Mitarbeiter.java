package sud.aufgaben.occupationalTherapy.container.mitarbeiter;

import java.util.Comparator;

public abstract class Mitarbeiter implements Comparable<Mitarbeiter> {

    public static class MitarbeiterComparator implements Comparator<Mitarbeiter> {

        @Override
        public int compare(Mitarbeiter a, Mitarbeiter b) {
            return Double.compare(a.einkommen(), b.einkommen());
        }

    }

    private int id;
    private String name;

    // Deklaration der Signatur "Ich weiß nicht wie, sondern nur dass..."
    // "abstract" definiert das Grundprinzip der Methode (Signatur -> Name, Parameter und Rückgabetyp)
    // wird ohne Inhalt deklariert

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

    public abstract double einkommen();

    public int getID() {
        return this.id;
    }

    /**
     * Nur 4-stellige IDs sind gültig.
     */
    protected void setID(int id) throws IllegalArgumentException {
        if (id > 999 && id < 10000) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id ist nicht im gültigen Bereich");
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        String bereinigterName = "";
        boolean wortAnfang = true;

        for (char c : name.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (wortAnfang) {  // Wortanfang
                    bereinigterName += Character.toUpperCase(c);  // Macht den Buchstaben zu einem Großbuchstaben
                    wortAnfang = false;
                } else {
                    bereinigterName += c;
                }

            } else if (c >= 'A' && c <= 'Z') {
                if (wortAnfang) {
                    bereinigterName += c;
                    wortAnfang = false;
                } else {
                    bereinigterName += Character.toLowerCase(c);  // Macht den Buchstaben zu einem Kleinbuchstaben
                }

            } else if (c == ' ') {
                bereinigterName += c;
                wortAnfang = true;
            } else {
                System.out.println("Buchstabe " + c + " als wird als Teil eines Mitarbeiternamens ignoriert.");
            }
        }

        if (bereinigterName.length() > 1) {
            this.name = bereinigterName;
        } else {
            throw new IllegalArgumentException("Name ist zu kurz oder enthält falsche Zeichen");
        }
    }

    @Override
    public int compareTo(Mitarbeiter o) {
        return this.getName().compareTo(o.getName());
    }

    public String toString() {
        return "ID: " + id + " Name: " + name;
    }

}
