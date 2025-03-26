package src.main.dsa.leetcode.daily_practice_problem.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Two_2D_Arrays_by_Summing_Values {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(mergeArrays(new int[][]{{1, 2}, {2, 3}, {4, 5}}, new int[][]{{1, 4}, {3, 2},
                {4, 1}})));
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        if (nums1.length == 0)
            return nums2;
        if (nums2.length == 0)
            return nums1;

        int i = 0;
        int j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                int[] temp = new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]};
                list.add(temp);
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        while (i < nums1.length) {
            list.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            list.add(nums2[j]);
            j++;

        }
//        int[][] resp = new int[list.size()][2];
//        int index = 0;
//        for (int[] ints : list) {
//            resp[index] = ints;
//            index++;
//        }
//        return resp;
        return list.toArray(new int[list.size()][]);
    }
}
