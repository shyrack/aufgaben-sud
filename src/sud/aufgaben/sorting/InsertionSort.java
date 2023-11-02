package sorting;

import java.util.Arrays;

public class InsertionSort {

    private final int[] arr;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return this.arr;
    }

    public void sort() {
        for (int i = 1; i < this.arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                swap(j - 1, j);
                j--;
            }
        }
    }

    private void swap(int a, int b) {
        int temp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = temp;
    }

    public static int[] generateRandomArr(int arrSize, int maxValue) {
        int[] out = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            out[i] = (int) (Math.random() * maxValue);
        }

        return out;
    }

    public static void main(String[] args) {
        int[] randomArr = InsertionSort.generateRandomArr(50, 200);
        System.out.println(Arrays.toString(randomArr));
        InsertionSort insertionSort = new InsertionSort(randomArr);
        insertionSort.sort();
        System.out.println(Arrays.toString(insertionSort.getArr()));
    }

}
