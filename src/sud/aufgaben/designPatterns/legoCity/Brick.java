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

    public String getColor() {
        return this.color;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public int getSize() {
        return this.size;
    }
}
