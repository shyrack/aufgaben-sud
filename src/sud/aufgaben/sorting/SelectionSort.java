package sorting;

import java.util.Arrays;

public class SelectionSort {

    private int[] nums;

    public SelectionSort(int[] nums) {
        this.nums = nums;
    }

    public int[] getNums() {

        return this.nums;
    }

    public void sort() {
        int minIndex = 0;
        for (int i = 1; i < this.nums.length; i++) {
            if (this.nums[i] < this.nums[minIndex]) {
                minIndex = i;
            }
        }

    }

    public static int[] generateRandomArr(int arrSize, int maxValue) {
        int[] out = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            out[i] = (int) (Math.random() * maxValue);
        }

        return out;
    }

    public static void main(String[] args) {
        int[] randomArr = SelectionSort.generateRandomArr(25000, 1000000);
        SelectionSort sorter = new SelectionSort(randomArr);
        System.out.println(Arrays.toString(sorter.getNums()));
    }

}
