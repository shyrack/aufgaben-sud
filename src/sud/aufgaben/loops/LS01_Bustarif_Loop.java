package loops;

import java.util.Scanner;

public class LS01_Bustarif_Loop {

    private static final String[] NUMS = {"null", "eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Bitte geben Sie eine Zahl zwischen 0 und 10 ein:");
            int num = scanner.nextInt();

            System.out.println("Eingabe: " + num + " Ausgabe: " + NUMS[num]);
        }

        scanner.close();
    }

}
