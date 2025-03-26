package src.main.dsa.neetcode.two_fifty.two_pointer;

import java.util.*;

public class Three_Sum {

    public static void main(String[] args) {
//        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
        System.out.println(threeSumV2(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(threeSum(new int[] {0,1,1}));
//        System.out.println(threeSum(new int[] {0,0,0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(-(nums[i] + nums[j]))) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(map.get(-(nums[i] + nums[j])));
                    Collections.sort(temp);
                    set.add(temp);
                } /*else*/
                map.put(nums[j], nums[j]);
            }
        }
        return set.stream().toList();
    }

    public static List<List<Integer>> threeSumV2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                    while (nums[k] == nums[k + 1] && k > j)
                        k--;
                    while (nums[j] == nums[j - 1] && j < k)
                        j++;
                }
            }
        }
        return res;
    }
}
