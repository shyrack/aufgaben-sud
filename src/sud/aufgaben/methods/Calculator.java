package sud.aufgaben.methods;

import java.util.Scanner;

public class Calculator {

    public static double readNumber(String blubb) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(blubb);
        double next = scanner.nextDouble();
        scanner.close();
        return next;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static void selectMenu() {
        System.out.println("blubb, blubber, blubbs, bubb");
    }

    public static double calculate(String blubb, double a, double b) {
        switch (blubb) {
            case "add":
                return add(a, b);
            case "multiply":
                return multiply(a, b);
            case "subtract":
                return subtract(a, b);
            case "divide":
                return divide(a, b);
            default:
                return 0;
        }
    }

    public static void print(double d) {
        System.out.println(d);
    }

    public static String readConsole(String statement) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(statement);
        String next = scanner.next();
        scanner.close();
        return next;
    }

    public static void main(String[] args) {

    }

}
