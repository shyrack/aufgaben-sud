package sud.aufgaben.occupationalTherapy.a_man_has_fallen_into_a_river;

public class in_lego_city {
    public static void main(String[] args) {
        simulateCity();
    }

    private static void simulateCity() {

    }

    private static LegoBauteil getWand(int anzahlSteine) {
        Legostein stein = new Legostein("rot", 20, 0.1);
        LegoKomposition wand = new LegoKomposition();
        for (int i = 0; i < anzahlSteine; i++) {
            wand.addTeil(stein);
        }
        return wand;
    }

    private static LegoBauteil getRaum(int anzahlMauern) {
        LegoKomposition raum = new LegoKomposition();
        for (int i = 0; i < anzahlMauern; i++) {
            raum.addTeil(getWand(500));
        }
        return raum;
    }

    private static LegoBauteil getHaus(){
        return new Legostein("rot", 20, 0.05);
    };
//    public static void main(String[] args) {
//        simulateCity();
//    }
//
//    private static void simulateCity() {
//
//    }
//
//    private static LegoBauteil getWand(int anzahlSteine) {
//        Legostein stein = new Legostein("rot", 20, 0.1);
//        LegoKomposition wand = new LegoKomposition();
//        for (int i = 0; i < anzahlSteine; i++) {
//            wand.addTeil(stein);
//        }
//        return wand;
//    }
//
//    private static LegoBauteil getRaum(int anzahlMauern) {
//        LegoKomposition raum = new LegoKomposition();
//        for (int i = 0; i < anzahlMauern; i++) {
//            raum.addTeil(getWand());
//        }
//    }
//
//    private static LegoBauteil getHaus(){
//
//    };
}
