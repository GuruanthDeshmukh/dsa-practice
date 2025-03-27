package src.main.dsa.feb23_2025;

import java.util.Arrays;

public class Sort_Colors {

    public static void main(String[] args) {
        int[] arr = new int[] {2,0,2,1,1,0};
        System.out.println(Arrays.toString(arr));
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = new int[] {2,0,1};
        System.out.println(Arrays.toString(arr1));
        sortColors(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length-1;
        while (j <= k) {
            if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else if (nums[j] == 1) {
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
