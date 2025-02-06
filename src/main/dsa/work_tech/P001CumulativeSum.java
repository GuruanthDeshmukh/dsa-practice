package src.main.dsa.work_tech;

import java.util.Arrays;

public class P001CumulativeSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getCumulativeSum(new int[]{1, 2, 3, 4})));
    }

    static int[] getCumulativeSum(int[] arr) {
        // add your logic here
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        return arr;
    }
}
