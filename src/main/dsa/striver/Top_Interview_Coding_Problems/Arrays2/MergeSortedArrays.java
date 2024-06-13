package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays2;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] q) {
        Solution s = new Solution();
        Integer[] nums1 = new Integer[]{1, 2, 3, 0, 0, 0};
        Integer[] nums2 = new Integer[]{2, 3, 4};
        s.merge(nums1, nums1.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }
}

class Solution {
    public void merge(Integer[] nums1, int m, Integer[] nums2, int n) {

//        int p1 = m - 1;
//        int p2 = n - 1;
//        int pMerge = m + n - 2;
//
//        while (p2 >= 0) {
//            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
//                pMerge--;
//                p1--;
//                nums1[pMerge] = nums1[p1];
//            } else {
//                pMerge--;
//                p2--;
//                nums1[pMerge] = nums2[p2];
//            }
//        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums1[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            nums1[k++] = nums1[i++];
        }

        while (j < n) {
            nums1[k++] = nums2[j++];
        }

    }
}
