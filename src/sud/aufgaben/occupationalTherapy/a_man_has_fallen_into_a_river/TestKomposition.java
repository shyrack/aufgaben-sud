package sud.aufgaben.occupationalTherapy.a_man_has_fallen_into_a_river;

public class TestKomposition {
    public static void main(String[] args) throws Exception {
        TestLegostein();
        TestKleineKomposition();
    }

    private static void TestLegostein() throws Exception {
        System.out.println("-------TEST LEGOSTEIN-------");
        Legostein stein = new Legostein("rot", 5, 0.05);
        double preis = stein.preis();

        if (preis != 0.05) {
            throw new Exception("Der Preis des Legosteins ist nicht 0.05€. Tatsaechlicher Preis: " + preis + "€");
        }
    }

    private static void TestKleineKomposition() throws Exception {
        System.out.println("-------TEST KLEINE KOMPOSITION-------");
        Legostein stein1 = new Legostein("rot", 10, 0.05);
        Legostein stein2 = new Legostein("gelb", 5, 0.10);

        LegoKomposition komposition = new LegoKomposition();
        komposition.addTeil(stein1);
        komposition.addTeil(stein2);

        double preis = komposition.preis();

        if (preis != 0.15) {
            throw new Exception("Der Preis des Legosteins ist nicht 0.15€. Tatsaechlicher Preis: " + preis + "€");
        }
    }
}
