/*
 * Klassenvorlage mit Methode zum Generieren eines Arrays mit Zufallszahlen oder dem bekannten Beispielarray
 */


package sorting;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

public class Quicksort_Kuerzel {

    static int seed = 42;                                   // Sorgt dafuer, dass das Array reproduzierbar ist
    static int lowerBound = 0;                              // Untergrenze der Werte
    static int upperBound = 100;                            // Obergrenze der Werte
    static int arrSize = 20000;                             // Laenge des Arrays
    public static int[] intArr = new int[arrSize];

    public static int[] getRandomIntArray(int size, int lower, int upper) {
        Random rd = new Random(seed);
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = abs(rd.nextInt() + lower % upper);             // Werte in Array ablegen: mit Modulo, um den Wertebereich zu begrenzen, und absolut, um nur positive Werte zu erhalten.
        }
        return arr;
    }

    public static void main(String[] args) {

        intArr = getRandomIntArray(arrSize, lowerBound, upperBound);    // Erzeugen des Arrays
        //intArr = new int[]{ 28, 58, 54, 17, 91, 11, 80, 23 }; 		// Alternativ Beispielarray aus der letzten Stunde zum Testen

        System.out.println("Unsortiert: " + Arrays.toString(intArr));

    }
}
