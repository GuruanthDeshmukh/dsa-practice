package src.main.dsa.feb23_2025;

import java.util.Arrays;

public class Merge_Sorted_Array {

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,3,0,0,0};
        int[] arr2 = new int[] {2,5,6};
        System.out.println(Arrays.toString(arr1));
        merge(arr1, 3, arr2,3);
        System.out.println(Arrays.toString(arr1));
        int[] arr3 = new int[] {1};
        int[] arr4 = new int[] {};
        System.out.println(Arrays.toString(arr3));
        merge(arr3, 1, arr4,0);
        System.out.println(Arrays.toString(arr4));
        int[] arr5 = new int[] {4,0,0,0,0,0};
        int[] arr6 = new int[] {1,2,3,5,6};
        System.out.println(Arrays.toString(arr5));
        merge(arr5, 1, arr6,5);
        System.out.println(Arrays.toString(arr5));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0)
            return;

        int index1 = m-1;
        int index2 = n-1;
        int i = nums1.length-1;

        while (index2 >= 0 && index1 >= 0) {
            if (nums2[index2] >= nums1[index1]) {
                nums1[i] = nums2[index2];
                index2--;
            } else {
                nums1[i] = nums1[index1];
                index1--;
            }
            i--;
        }

        while (index2 >= 0) {
            nums1[i] = nums2[index2];
            index2--;
            i--;
        }


    }

    private static void swap(int[] nums1, int[] nums2, int index1, int index2) {
        int temp = nums1[index1];
        nums1[index1] = nums2[index2];
        nums2[index2] = temp;
    }
}
