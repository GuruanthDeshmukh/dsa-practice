package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

import java.util.Arrays;

public class Sort_Colors {

    public static void main(String[] args) {
        int[] a1 = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(a1);
        System.out.println(Arrays.toString(a1));
        int[] a2 = new int[]{2, 0, 1};
        sortColors(a2);
        System.out.println(Arrays.toString(a2));
        int[] a3 = new int[]{1, 2, 0};
        sortColors(a3);
        System.out.println(Arrays.toString(a3));
        int[] a4 = new int[]{2, 1, 0};
        sortColors(a4);
        System.out.println(Arrays.toString(a4));
    }

    public static void sortColors(int[] nums) {
        int i, j, k;
        i = 0;
        j = 1;
        k = nums.length - 1;
        while (j <= k) {
            if (nums[j] >= nums[i] && nums[j] > nums[k]) {
                swap(nums, j, k);
                k--;
            } else if (nums[j] >= nums[i]) {
                j++;
            } else {
                swap(nums, i, j);
                i++;
                j++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
