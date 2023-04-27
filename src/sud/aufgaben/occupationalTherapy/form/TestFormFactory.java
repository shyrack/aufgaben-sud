package sud.aufgaben.occupationalTherapy.form;

import java.io.IOException;
import java.util.Scanner;

public class TestFormFactory {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FormFactory factory = new FormFactory();
        Form polygon = factory.create("polygon", scanner);
        Form rectangle = factory.create("rectangle", scanner);
        Form triangle = factory.create("triangle", scanner);
        Form circle = factory.create("circle", scanner);
        scanner.close();

        Form[] forms = {polygon, rectangle, triangle, circle};
        for (Form form : forms) {
            System.out.println("-----" + form.getClass().getSimpleName() + "-----");
            System.out.println("Fläche: " + form.area());
            System.out.println("Umfang: " + form.circumference());
        }
    }
}