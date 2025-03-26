package src.main.dsa.neetcode.two_fifty.two_pointer;

import java.util.Arrays;

public class Merge_Sorted_Array {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = nums1.length - 1;
        int nums1pointer = m - 1;
        int nums2pointer = n - 1;
        while (end >= 0 && nums1pointer >= 0 && nums2pointer >= 0) {
            if (nums2[nums2pointer] >= nums1[nums1pointer]) {
                nums1[end] = nums2[nums2pointer];
                nums2pointer--;
            } else {
                nums1[end] = nums1[nums1pointer];
                nums1pointer--;
            }
            end--;
        }
        while (end >= 0 && nums2pointer >= 0) {
            nums1[end] = nums2[nums2pointer];
            nums2pointer--;
            end--;
        }
        while (end >= 0 && nums1pointer >= 0) {
            nums1[end] = nums1[nums1pointer];
            nums1pointer--;
            end--;
        }
    }

}
