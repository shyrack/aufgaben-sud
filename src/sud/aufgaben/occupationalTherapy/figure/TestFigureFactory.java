package sud.aufgaben.occupationalTherapy.figure;

import java.util.Scanner;

public class TestFigureFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FigureFactory figureFactory = new FigureFactory();

        Figure cone = figureFactory.create("cone", scanner);
        Figure pyramid3 = figureFactory.create("threesidedpyramid", scanner);
        Figure pyramid4 = figureFactory.create("foursidedpyramid", scanner);
        Figure pyramidN = figureFactory.create("polygonalpyramid", scanner);
        Figure prism = figureFactory.create("prism", scanner);
        Figure sphere = figureFactory.create("sphere", scanner);
        scanner.close();

        Figure[] figures = {cone, pyramid3, pyramid4, pyramidN, prism, sphere};
        for (Figure figure : figures) {
            System.out.println("-----" + figure.getClass().getSimpleName() + "-----");
            System.out.println("Oberfläche: " + figure.surface());
            System.out.println("Volumen: " + figure.volume());
        }
    }
}