package sorting;

import java.util.Arrays;

public class Quicksort {

    public static int[] startSort(int[] arr) {
        Quicksort.sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high || low < 0) return;

        int p = partition(arr, low, high);
        Quicksort.sort(arr, low, p);
        Quicksort.sort(arr, p + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotIndex = high - 1;

        int i = low - 1;

        for (int j = low; j < high - 1; i++) {
            if (arr[j] < arr[pivotIndex]) {
                i++;
                Quicksort.swap(arr, i, j);
            }
        }

        i++;
        Quicksort.swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] unsortedArr = Quicksort_Kuerzel.getRandomIntArray(20000, 0, 100);
        int[] sortedArr = Quicksort.startSort(unsortedArr);

        System.out.println(Arrays.toString(sortedArr));
    }

}
