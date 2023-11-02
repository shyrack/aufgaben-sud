package occupationalTherapy.a_man_has_fallen_into_a_river;

public class TestKomposition {
    private static Legostein roterStein = new Legostein("rot", 10, 0.05);
    private static Legostein blauerStein = new Legostein("blau", 10, 0.1);
    private static Legostein goldenerStein = new Legostein("gold", 20, 50);
    private static LegoKomposition kleineKomposition = new LegoKomposition();
    private static LegoKomposition grosseKomposition = new LegoKomposition();

    public static void main(String[] args) throws Exception {
        TestLegostein();
        TestKleineKomposition();
        TestKompositionMitKomposition();
    }

    private static void TestLegostein() throws Exception {
        System.out.println("-------TEST LEGOSTEIN-------");
        assertPreis(roterStein, 0.05);
    }

    private static void TestKleineKomposition() throws Exception {
        System.out.println("-------TEST KLEINE KOMPOSITION-------");

        kleineKomposition
            .addTeil(roterStein)
            .addTeil(blauerStein);

        assertPreis(kleineKomposition, 0.15);
    }

    private static void TestKompositionMitKomposition() throws Exception {
        System.out.println("-------TEST GROSSE KOMPOSITION-------");

        grosseKomposition
            .addTeil(goldenerStein)
            .addTeil(blauerStein)
            .addTeil(kleineKomposition);

        assertPreis(grosseKomposition, 50.25);
    }

    private static void assertPreis(LegoBauteil teil, double expected) throws Exception {
        if (expected != teil.preis()) {
            throw new Exception("Price of " + teil.preis() + " EURO does not match the expected price of " + expected + " EURO");
        } else {
            System.out.println("Preis des Lego-Bauteils ist " + teil.preis() + " EURO");
        }
    }
}
