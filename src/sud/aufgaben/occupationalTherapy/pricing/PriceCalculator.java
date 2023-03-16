package sud.aufgaben.occupationalTherapy.pricing;

import sud.aufgaben.occupationalTherapy.figure.Figure;

public class PriceCalculator {
    
    private Figure figure;
    private Material coating;
    private Material filling;

    public PriceCalculator(Figure figure, Material coating, Material filling) {
        this.figure = figure;
        this.coating = coating;
        this.filling = filling;
    }

    public double calculateCoatingPrice() {
        return this.figure.surface() * this.coating.getPrice();
    }

    public double calculateFillingPrice() {
        return this.figure.volume() * this.filling.getPrice();
    }

    public double calculatePrice() {
        return this.calculateCoatingPrice() + this.calculateFillingPrice();
    }

    public Figure getFigure() {
      return this.figure;
    }

    public Material getCoating() {
      return this.coating;
    }

    public Material getFilling() {
      return this.filling;
    }

}
