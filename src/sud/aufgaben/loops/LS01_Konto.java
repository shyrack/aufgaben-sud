package loops;

import java.util.Scanner;

public class LS01_Konto {

    public static void main(String[] args) {
        int balance = 1000;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie den Dispositionskredit ein:");
        int dispositionCredit = scanner.nextInt();

        do {
            System.out.println("Bitte geben Sie den Betrag ein:");
            int amount = scanner.nextInt();
            balance -= amount;
        } while (-dispositionCredit <= balance);

        System.out.println("Sie haben ihr Konto überzogen!");

        scanner.close();
    }

}
