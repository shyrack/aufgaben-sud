package sud.aufgaben.occupationalTherapy.figure;

import java.util.Arrays;
import java.util.Scanner;

import sud.aufgaben.occupationalTherapy.iFactory;
import sud.aufgaben.occupationalTherapy.figure.pyramid.Cone;
import sud.aufgaben.occupationalTherapy.figure.pyramid.FourSidedPyramid;
import sud.aufgaben.occupationalTherapy.figure.pyramid.PolygonalPyramid;
import sud.aufgaben.occupationalTherapy.figure.pyramid.ThreeSidedPyramid;
import sud.aufgaben.occupationalTherapy.form.*;

public class FigureFactory implements iFactory<Figure> {
    private String[] figures = {
        "CONE",
        "FOURSIDEDPYRAMID",
        "THREESIDEDPYRAMID",
        "POLYGONALPYRAMID",
        "PRISM",
        "SPHERE"
    };

    public Figure create(String type, Scanner scanner) {
        if (!Arrays.stream(figures).anyMatch(type::equals)) {
            throw new IllegalArgumentException("Form of type " + type + " is not known!");
        }

        double h, r, a, b, c;
        FormFactory formFactory = new FormFactory();

        System.out.println("--- CREATING " + type + " ---");
        switch (type) {
            case "CONE":
                System.out.println("Enter the radius of the base circle");
                r = scanner.nextDouble();
                System.out.println("Enter the height of the cone");
                h = scanner.nextDouble();
                return new Cone(new Circle(r), h);
            case "FOURSIDEDPYRAMID":
                System.out.println("Enter length a of the base rectangle");
                a = scanner.nextDouble();
                System.out.println("Enter length b of the base rectangle");
                b = scanner.nextDouble();
                System.out.println("Enter the height of the pyramid");
                h = scanner.nextDouble();
                return new FourSidedPyramid(new Rectangle(a, b), h);
            case "THREESIDEDPYRAMID":
                System.out.println("Enter length a of the base triangle");
                a = scanner.nextDouble();
                System.out.println("Enter length b of the base triangle");
                b = scanner.nextDouble();
                System.out.println("Enter length c of the base triangle");
                c = scanner.nextDouble();
                System.out.println("Enter the height of the pyramid");
                h = scanner.nextDouble();
                return new ThreeSidedPyramid(new Triangle(a, b, c), h);
            case "POLYGONALPYRAMID":
                System.out.println("Enter the radius of the base polygon");
                r = scanner.nextDouble();
                System.out.println("Enter the amount of corners in the base polygon");
                int n = scanner.nextInt();
                System.out.println("Enter the height of the pyramid");
                h = scanner.nextDouble();
                return new PolygonalPyramid(new Polygon(r, n), h);
            case "PRISM":
                System.out.println("Enter the type of base (ALL CAPS)");
                Form base = formFactory.create(scanner.next(), scanner);
                System.out.println("Enter the height of the prism");
                h = scanner.nextDouble();
                return new Prism(base, h);
            case "SPHERE":
                System.out.println("Enter the radius of the sphere");
                r = scanner.nextDouble();
                return new Sphere(r);
            default:
                scanner.close();
                throw new IllegalArgumentException();
        }
    }
}