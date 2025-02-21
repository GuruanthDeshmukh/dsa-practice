package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_II {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));     // 3
        System.out.println(majorityElement(new int[]{1, 2}));      // 1, 2
        System.out.println(majorityElement(new int[]{1}));         // 1
        System.out.println(majorityElement(new int[]{2, 2}));       // 2
        System.out.println(majorityElement(new int[]{2, 2, 1, 3}));   // 2
        System.out.println(majorityElement(new int[]{0, 0, 0}));     // 0
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>(2);
        int majorityEle1 = Integer.MIN_VALUE;
        int majorityEle2 = Integer.MIN_VALUE;
        int majorityCount1 = 0;
        int majorityCount2 = 0;

        for (int num : nums) {
            if (majorityCount1 == 0 && num != majorityEle2) {
                majorityEle1 = num;
                majorityCount1++;
            } else if (majorityCount2 == 0 && num != majorityEle1) {
                majorityEle2 = num;
                majorityCount2++;
            } else if (majorityEle1 == num) {
                majorityCount1++;
            } else if (majorityEle2 == num) {
                majorityCount2++;
            } else {
                majorityCount2--;
                majorityCount1--;
            }
        }
        majorityCount1 = 0;
        majorityCount2 = 0;
        for (int num : nums) {
            if (num == majorityEle1)
                majorityCount1++;
            else if (num == majorityEle2) {
                majorityCount2++;
            }
        }
        if (majorityCount1 > nums.length / 3 && majorityEle1 != Integer.MIN_VALUE)
            res.add(majorityEle1);
        if (majorityCount2 > nums.length / 3 && majorityEle2 != Integer.MIN_VALUE)
            res.add(majorityEle2);
        return res;
    }
}
