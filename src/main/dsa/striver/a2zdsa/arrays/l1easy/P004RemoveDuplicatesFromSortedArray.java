package src.main.dsa.striver.a2zdsa.arrays.l1easy;

import java.util.Arrays;

public class P004RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(Arrays.toString(arr));
        removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int x = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                nums[x] = nums[i];
                x++;
            }
        }
        return x;
    }
}
