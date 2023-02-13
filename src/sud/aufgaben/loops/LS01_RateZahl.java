package sud.aufgaben.loops;

import java.util.Scanner;

public class LS01_RateZahl {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = (int) (Math.random() * 15);
        int tries = 1;
        int guess;

        do {
            System.out.println("Bitte raten Sie eine Zahl zwischen 0 und 15:");
            guess = scanner.nextInt();

            if (guess < num) {
                System.out.println(guess + " ist kleiner als die Zahl!");
            } else if (guess > num) {
                System.out.println(guess + " ist größer als die Zahl!");
            } else {
                System.out.println(guess + " war die richtige Zahl! Versuche: " + tries);
            }

            tries++;
        } while (guess != num);

        scanner.close();
    }

}
