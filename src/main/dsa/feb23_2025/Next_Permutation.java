package src.main.dsa.feb23_2025;

import java.util.Arrays;

public class Next_Permutation {

    public static void main(String[] args) {
//        int[] arr = new int[] {1,2,3};
//        System.out.println(Arrays.toString(arr));
//        nextPermutation(arr);
//        System.out.println(Arrays.toString(arr));
//        int[] arr2 = new int[] {3,2,1};
//        System.out.println(Arrays.toString(arr2));
//        nextPermutation(arr2);
//        System.out.println(Arrays.toString(arr2));
//        int[] arr3 = new int[] {2,3,1};
//        System.out.println(Arrays.toString(arr3));
//        nextPermutation(arr3);
//        System.out.println(Arrays.toString(arr3));
        int[] arr4 = new int[] {2,3,1,3,3};
        System.out.println(Arrays.toString(arr4));
        nextPermutation(arr4);
        System.out.println(Arrays.toString(arr4));
    }

    public static void nextPermutation(int[] nums) {
        int swapIndex = -1;
        for (int i = nums.length-1; i > 0 ; i--) {
            if (nums[i] > nums[i-1]) {
                swapIndex = i - 1;
                break;
            }
        }
        if (swapIndex == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        int immediateNextNumber = Integer.MAX_VALUE;
        int immediateNextNumberIndex = -1;
        for (int i = swapIndex+1; i < nums.length; i++) {
            if (nums[i] <= immediateNextNumber && nums[i] > nums[swapIndex]) {
                immediateNextNumberIndex = i;
                immediateNextNumber = nums[i];
            }
        }
        swap(nums, swapIndex, immediateNextNumberIndex);
        reverse(nums, swapIndex+1, nums.length-1);

    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
