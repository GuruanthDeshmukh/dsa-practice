package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSome {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }

    /**
     * Not mentioning brute force approaches as they are of N^4 and N^3.
     * <a href="https://www.youtube.com/watch?v=eD95WRfh81c"> Video reference </a>
     *
     * @param nums Array of number
     * @param target Desired target
     * @return list of desired elements equal to sum of target
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        Arrays.sort(nums);
        while (i < nums.length) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            while (j < nums.length) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                    if (target == sum) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        result.add(temp);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (target > sum) {
                        k++;
                    } else {
                        l--;
                    }
                }
                j++;
                while (j < nums.length && nums[j] == nums[j - 1]) j++;
            }
            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) i++;
        }

        return result;
    }
}
