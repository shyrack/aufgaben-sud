package loops;

import java.util.Scanner;

public class LS01_Quersumme {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum = 0;

        System.out.println("Geben Sie eine Zahl ein:");
        String num = scanner.next();

        for (char c : num.toCharArray()) {
            byte b = Byte.parseByte(Character.toString(c));
            sum += b;
        }

        System.out.println("Die Quersumme ist: " + sum);

        scanner.close();
    }

}
