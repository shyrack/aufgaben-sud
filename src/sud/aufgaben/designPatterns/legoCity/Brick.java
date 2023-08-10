package sud.aufgaben.designPatterns.legoCity;

public class Brick extends Part {
    private String color;
    private double price;
    private int size;

    public Brick(String color, double price, int size) {
        this.color = color;
        this.price = price;
        this.size = size;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
