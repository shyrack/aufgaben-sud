package sud.aufgaben.designPatterns.legoCity;

public class Main {
    private static Part createBrick() {
        return new Brick("blue", 0.1, 2);
    }

    private static Composition createBuilding() {
        Composition building = new Composition();

        for (int i = 0; i < 500; i++) {
            building.addPart(Main.createBrick());
        }

        return building;
    }

    private static Composition createCity() {
        Composition city = new Composition();

        for (int i = 0; i < 5000; i++) {
            city.addPart(Main.createBuilding());
        }

        return city;
    }

    private static void advanceCity(Composition part) {
        Part randomBrick = new Brick("green", 20, 50);
        Part anotherRandomBrick = new Brick("yellow", 400, 20);

        part.addPart(randomBrick);
        part.addPart(anotherRandomBrick);
    }

    public static void main(String[] args) {
        Composition city = Main.createCity();
        Main.advanceCity(city);
        System.out.print("Price: ");
        System.out.println(city.getPrice() + "€");
    }
}
