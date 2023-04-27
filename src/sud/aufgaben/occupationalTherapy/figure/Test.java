package sud.aufgaben.occupationalTherapy.figure;

import sud.aufgaben.occupationalTherapy.figure.pyramid.*;
import sud.aufgaben.occupationalTherapy.form.Circle;
import sud.aufgaben.occupationalTherapy.form.Polygon;
import sud.aufgaben.occupationalTherapy.form.Rectangle;
import sud.aufgaben.occupationalTherapy.form.Triangle;
import sud.aufgaben.occupationalTherapy.pricing.Material;
import sud.aufgaben.occupationalTherapy.pricing.MaterialReader;
import sud.aufgaben.occupationalTherapy.pricing.PriceCalculator;
import sud.aufgaben.util.CSVWriter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        // testSphere();
        // testPyramids();
        // testPrism();
        // testPrice();
        testCSV();
    }

    private static void testSphere() {
        Sphere sphere = new Sphere(2.5);
        System.out.println("-----------| " + sphere.getClass().getSimpleName() + " |-----------");
        System.out.println("Surface: " + sphere.surface());
        System.out.println("Volume: " + sphere.volume());
    }

    private static void testPyramids() {
        Circle coneBase = new Circle(2.5);
        Triangle threeSidedPyramidBase = new Triangle(2, 2, 2);
        Rectangle fourSidedPyramidBase = new Rectangle(2, 2);
        Polygon polygonalPyramidBase = new Polygon(2.5, 5);
        PyramidalFigure<?>[] figures = { new Cone(coneBase, 5), new ThreeSidedPyramid(threeSidedPyramidBase, 2),
                new FourSidedPyramid(fourSidedPyramidBase, 2), new PolygonalPyramid(polygonalPyramidBase, 2) };
        Arrays.stream(figures).forEach(pyramidalFigure -> {
            System.out.println("-----------| " + pyramidalFigure.getClass().getSimpleName() + " |-----------");
            System.out.println("Surface: " + pyramidalFigure.surface());
            System.out.println("Volume: " + pyramidalFigure.volume());
        });
    }

    private static void testPrism() {
        Circle cylinderBase = new Circle(2.5);
        Triangle threeSidedPrism = new Triangle(2, 2, 2);
        Rectangle fourSidedPrism = new Rectangle(2, 2);
        Prism<?>[] figures = { new Prism<>(cylinderBase, 5), new Prism<>(threeSidedPrism, 5),
                new Prism<>(fourSidedPrism, 5) };
        Arrays.stream(figures).forEach(prism -> {
            System.out.println("-----------| " + prism.getClass().getSimpleName() + ": "
                    + prism.getBase().getClass().getSimpleName() + " |-----------");
            System.out.println("Surface: " + prism.surface());
            System.out.println("Volume: " + prism.volume());
        });
    }

    private static void testPrice() {
        MaterialReader coatingReader = new MaterialReader("Materialpreise Oberflaechen.csv");
        MaterialReader fillingReader = new MaterialReader("Materialpreise Fuellung.csv");
        try {
            Map<String, Material> coatingMaterialMap = coatingReader.readFile();
            Map<String, Material> fillingMaterialMap = fillingReader.readFile();
            printMaterialMap(coatingMaterialMap);
            System.out.println("-".repeat(25));
            printMaterialMap(fillingMaterialMap);

            PolygonalPyramid pyramid = new PolygonalPyramid(new Polygon(15, 19), Math.PI);
            PriceCalculator calculator = new PriceCalculator(pyramid, coatingMaterialMap.get("Lack"),
                    fillingMaterialMap.get("Aluminium"));
            System.out.println("-".repeat(25));
            System.out.println("Pyramid material price: " + calculator.calculatePrice());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printMaterialMap(Map<String, Material> map) {
        map.forEach((key, val) -> {
            System.out.println("Material: " + key + "\t\t" + "Price: " + val.getPrice());
        });
    }

    private static void testCSV() {
        try (CSVWriter<Figure> writer = new CSVWriter<>(new File("./generated.csv"))) {
            Polygon polygon = new Polygon(5, 5);
            PolygonalPyramid pyramid = new PolygonalPyramid(polygon, 5);
            Sphere sphere = new Sphere(5);

            writer.writeT(pyramid);
            writer.writeT(sphere);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
