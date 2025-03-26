package src.main.dsa.neetcode.two_fifty.two_pointer;

import java.util.Arrays;

public class Rotate_Array {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = new int[]{-1, -100, 3, 99};
        System.out.println(Arrays.toString(arr1));
        rotate(arr1, 2);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = new int[]{-1};
        System.out.println(Arrays.toString(arr2));
        rotate(arr2, 1);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr3));
        rotate(arr3, 3);
        System.out.println(Arrays.toString(arr3));
        int[] arr4 = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(arr4));
        rotate(arr4, 4);
        System.out.println(Arrays.toString(arr4));
    }

    public static void rotate(int[] nums, int k) {
//        if (k % 2 != 0) {
//            reverse(nums, 0, k);
//            reverse(nums, k + 1, nums.length - 1);
//            reverse(nums, 0, nums.length - 1);
//        } else {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
//        }
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end && end < nums.length) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
