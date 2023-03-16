package sud.aufgaben.car;

public class Test {

    public static void main(String[] args) {
        Car car = new Car(37, 20, 7.1, 230);
        try {
            car.getIn("Andrè Löwens");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally..");
        }
    }

}
