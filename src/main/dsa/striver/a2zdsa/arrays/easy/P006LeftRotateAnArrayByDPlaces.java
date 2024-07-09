package src.main.dsa.striver.a2zdsa.arrays.easy;

import java.util.Arrays;

public class P006LeftRotateAnArrayByDPlaces {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};//2,1
        System.out.println(Arrays.toString(arr));
        rotate(arr, 1);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7};//5,6,7,1,2,3,4
        System.out.println(Arrays.toString(arr2));
        rotateV2(arr2, 3);
        System.out.println(Arrays.toString(arr2));
    }

    public static void rotate(int[] nums, int k) {
        if (1 >= nums.length)
            return;
        k = k % (nums.length);
        while (k > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
    }

    public static void rotateV2(int[] nums, int k) {
        if (1 >= nums.length)
            return;
        k = k % (nums.length);
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
