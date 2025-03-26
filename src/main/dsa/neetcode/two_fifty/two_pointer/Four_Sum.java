package src.main.dsa.neetcode.two_fifty.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && (nums[j] == nums[j - 1] || nums[j] == nums[i]))
                    continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        res.add(temp);
                        k++;
                        l--;
                        while (nums[l] == nums[l + 1] && l > k)
                            l--;
                        while (nums[k] == nums[k - 1] && k < l)
                            k++;
                    }
                }
            }
        }
        return res;
    }
}
