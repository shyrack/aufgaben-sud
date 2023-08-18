package sud.aufgaben.occupationalTherapy.form;

import java.util.Arrays;
import java.util.Scanner;

import sud.aufgaben.occupationalTherapy.Factory;

public class FormFactory implements Factory<Form> {

    private String[] forms = { "CIRCLE", "POLYGON", "RECTANGLE", "TRIANGLE" };

    public Form create(String type, Scanner scanner) {
        type = type.toUpperCase();
        if (!Arrays.stream(forms).anyMatch(type::equals)) {
            throw new IllegalArgumentException("Form of type " + type + " is not known!");
        }

        System.out.println("--- CREATING " + type + " ---");

        Form form;

        switch (type) {
        case "CIRCLE":
            System.out.println("Enter a radius for the circle");
            double cRadius = scanner.nextDouble();
            form = new Circle(cRadius);
            break;
        case "POLYGON":
            System.out.println("Enter a radius for the polygon");
            double pRadius = scanner.nextDouble();
            System.out.println("Enter the amount of corners in the polygon");
            int corners = scanner.nextInt();
            form = new Polygon(pRadius, corners);
            break;
        case "RECTANGLE":
            System.out.println("Enter the length of the first side");
            double rA = scanner.nextDouble();
            System.out.println("Enter the length of the second side");
            double rB = scanner.nextDouble();
            form = new Rectangle(rA, rB);
            break;
        case "TRIANGLE":
            System.out.println("Enter the length of the first side");
            double tA = scanner.nextDouble();
            System.out.println("Enter the length of the second side");
            double tB = scanner.nextDouble();
            System.out.println("Enter the length of the third side");
            double tC = scanner.nextDouble();
            form = new Triangle(tA, tB, tC);
            break;
        default:
            scanner.close();
            throw new IllegalArgumentException();
        }

        return form;
    }

}