package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

import java.util.Arrays;

public class D003_Reverse_an_Array {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 4, 3, 2, 6, 5, 0};
        System.out.println(Arrays.toString(a1));
        reverseArray(a1);
        System.out.println(Arrays.toString(a1));
    }

    public static void reverseArray(int[] arr) {
        // code here
        if (arr.length == 1 || arr.length == 0)
            return;

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
