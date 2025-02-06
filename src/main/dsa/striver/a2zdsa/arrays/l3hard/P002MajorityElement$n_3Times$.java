package src.main.dsa.striver.a2zdsa.arrays.l3hard;

import java.util.ArrayList;
import java.util.List;

public class P002MajorityElement$n_3Times$ {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 3, 4}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> resp = new ArrayList<>();
        int element1 = 0;
        int element2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != element2) {
                element1 = nums[i];
                count1++;
            } else if (count2 == 0 && nums[i] != element1) {
                element2 = nums[i];
                count2++;
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int element : nums) {
            if (element == element1) {
                count1++;
            } else if (element == element2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            resp.add(element1);
        } else if (count2 > nums.length / 3) {
            resp.add(element2);
        }

        return resp;
    }

}
