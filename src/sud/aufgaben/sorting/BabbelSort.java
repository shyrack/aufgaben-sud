package sorting;

import java.util.Arrays;

public class BabbelSort {

    private int[] nums;

    public BabbelSort(int[] nums) {
        this.nums = nums;
    }

    public int[] getNums() {

        return this.nums;
    }

    public void sort() {
        boolean sorting = false;

        for (int i = 1; i < this.nums.length; i++) {
            if (this.nums[i - 1] > this.nums[i]) {
                final int temp = this.nums[i - 1];
                this.nums[i - 1] = this.nums[i];
                this.nums[i] = temp;
                sorting = true;
            }
        }

        if (sorting) {
            this.sort();
        }
    }

    public void performanceSort() {
        for (int i = 0; i < this.nums.length; i++) {
            boolean sorting = false;
            for (int j = 1; j < this.nums.length; j++) {
                if (this.nums[j - 1] > this.nums[j]) {
                    final int temp = this.nums[j - 1];
                    this.nums[j - 1] = this.nums[j];
                    this.nums[j] = temp;
                    sorting = true;
                }
            }
            if (!sorting) {
                break;
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
        int[] randomArr = BabbelSort.generateRandomArr(100000, 100000);
        BabbelSort sorter = new BabbelSort(randomArr);
        long startTime = System.currentTimeMillis();
        sorter.sort();
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println(Arrays.toString(sorter.getNums()));
        System.out.println("Sorting took: " + elapsedTime + "ms");
    }

}
