package sud.aufgaben.occupationalTherapy.pricing;

public class Material {

    private String name;
    private double price;

    public Material(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
      return this.name;
    }

    public double getPrice() {
      return this.price;
    }
  
}
