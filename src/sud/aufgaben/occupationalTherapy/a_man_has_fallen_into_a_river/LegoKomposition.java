package occupationalTherapy.a_man_has_fallen_into_a_river;

import java.util.ArrayList;

public class LegoKomposition extends LegoBauteil {
    
    private ArrayList<LegoBauteil> teile;

    public LegoKomposition() {
        this.teile = new ArrayList<LegoBauteil>();
    }

    public double preis() {
        double rawPrice = this.teile
            .stream()
            .mapToDouble(teil -> teil.preis())
            .sum();

        // Round to 2 decimal points
        return Math.round(rawPrice * 100)/100.0;
    }

    public LegoKomposition addTeil(LegoBauteil teil) {
        this.teile.add(teil);
        return this;
    }    
}
