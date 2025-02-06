package src.main.dsa.striver.a2zdsa.arrays.l2medium;

import java.util.Arrays;

public class P008NextPermutation_FindNextLexicographicallyGreaterPermutation {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 5};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int decIndex = -1;
        int smallestIndex = 0;

        if (nums.length < 2)
            return;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] <= nums[i]) {
                continue;
            } else {
                decIndex = i;
                break;
            }
        }

        if (decIndex == -1) {
            sort(nums, 0);
            return;
        }

        for (int i = decIndex; i < nums.length; i++) {
            if (nums[i] > nums[decIndex]) {
                smallestIndex = i;
            }
        }

        swap(nums, decIndex, smallestIndex);

        sort(nums, decIndex + 1);
    }

    private static void sort(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j && i < nums.length) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
