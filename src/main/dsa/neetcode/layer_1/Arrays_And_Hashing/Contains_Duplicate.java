package src.main.dsa.neetcode.layer_1.Arrays_And_Hashing;

import java.util.HashSet;

public class Contains_Duplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
//            if (!set.add(num))
//                return true;
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }

}
