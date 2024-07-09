package src.main.dsa.gfg.problems;

import java.util.Arrays;

public class MaximumTripletProduct {

    public static void main(String[] args) {
        long[] arr = new long[]{-3, -5, 1, 0, 8, 3, -2};
        System.out.println(maxTripletProduct(arr, arr.length - 1));
    }

    public static long maxTripletProduct(long[] arr, int n) {
        // Complete the function
        Arrays.sort(arr);
        return Math.max(arr[0] * arr[1] * arr[arr.length - 1],
                arr[arr.length - 3] * arr[arr.length - 2] * arr[arr.length - 1]);
    }
}
