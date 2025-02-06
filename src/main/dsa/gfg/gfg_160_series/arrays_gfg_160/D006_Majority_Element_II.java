package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class D006_Majority_Element_II {

    public static void main(String[] args) {
        System.out.println(findMajority(new int[]{2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6}));
        System.out.println(findMajority(new int[]{1, 2, 3, 4, 5}));
    }

    public static List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        List<Integer> res = new ArrayList<>(2);

        if (nums.length < 3) {
            for (int num : nums) {
                if (!res.contains(num))
                    res.add(num);
            }
            return res;
        }

        int n1 = 0;
        int n2 = 0;
        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            if (c1 == 0 && num != n2) {
                n1 = num;
                c1++;
                continue;
            }
            if (c2 == 0 && num != n1) {
                n2 = num;
                c2++;
                continue;
            }
            if (num == n1 && num != n2) {
                c1++;
            } else if (num == n2 && num != n1) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        int temp1 = 0;
        int temp2 = 0;
        for (int num : nums) {
            if (num == n1)
                temp1++;
            else if (num == n2) {
                temp2++;
            }
        }
        if (temp1 > nums.length / 3)
            res.add(n1);
        if (temp2 > nums.length / 3)
            res.add(n2);

        Collections.sort(res);
        return res;
    }
}
