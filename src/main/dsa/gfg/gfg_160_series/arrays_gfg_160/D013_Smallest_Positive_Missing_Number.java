package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

import java.util.Arrays;

public class D013_Smallest_Positive_Missing_Number {

    public static void main(String[] args) {
//        System.out.println(missingNumber(new int[] {2, -3, 4, 1, 1, 7}));
//        System.out.println(missingNumberV2(new int[] {2, -3, 4, 1, 1, 7}));
//        System.out.println(missingNumber(new int[] {5, 3, 2, 5, 1}));
//        System.out.println(missingNumberV2(new int[] {5, 3, 2, 5, 1}));
//        System.out.println(missingNumber(new int[] {-8, 0, -1, -4, -3}));
//        System.out.println(missingNumberV2(new int[] {-8, 0, -1, -4, -3}));
//        System.out.println(missingNumber(new int[] {2, 6, 2, -8, -7, 8}));
//        System.out.println(missingNumberV2(new int[] {2, 6, 2, -8, -7, 8}));
//        System.out.println(missingNumber(new int[] {1, -1, -4}));
//        System.out.println(missingNumberV2(new int[] {1, -1, -4}));
//        System.out.println(missingNumber(new int[] {10, -1}));
//        System.out.println(missingNumberV2(new int[] {10, -1}));
//        System.out.println(missingNumberV2(new int[] {1, 2, 3, 4, 5}));
        System.out.println(missingNumber(new int[]{19, 16, 12, 7, -17, 4, -1, 7, -3, 4, 14, 18, 5, -8, 5, -11, 18, 13, 5, 1}));
        System.out.println(missingNumberV2(new int[]{19, 16, 12, 7, -17, 4, -1, 7, -3, 4, 14, 18, 5, -8, 5, -11, 18, 13, 5, 1}));
    }

    //Brute force
    public static int missingNumber(int[] arr) {
        // Your code here
        Arrays.sort(arr);
        boolean isOnePresent = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 0)
                continue;
            if (arr[i] == 1)
                isOnePresent = true;
            if (arr[i] == arr[i + 1] || arr[i] + 1 == arr[i + 1])
                continue;
            if (!isOnePresent && arr[i] > 1)
                return 1;
            return arr[i] + 1;
        }
        if (!isOnePresent && arr[arr.length - 1] != 1)
            return 1;
        return arr[arr.length - 1] + 1;
    }

    //Optimised
    public static int missingNumberV2(int[] arr) {
        // Your code here
        int i = 0;
        while (i < arr.length) {
            System.out.println(Arrays.toString(arr));
            if (i + 1 == arr[i] || arr[i] <= 0 || arr[i] >= arr.length || arr[i] == arr[arr[i] - 1]) {
                i++;
                continue;
            }
            System.out.println(Arrays.toString(arr));
            int temp = arr[arr[i] - 1];
            arr[arr[i] - 1] = arr[i];
            arr[i] = temp;
        }
        for (int j = 1; j <= arr.length - 1; j++) {
            if (j != arr[j - 1]) {
                return j;
            }
        }
        return arr.length;
    }

}
