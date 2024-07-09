package src.main.dsa.striver.a2zdsa.arrays.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P012FindTheNumberThatAppearsOnceAndOtherNumbersTwice {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1}));
        System.out.println(singleNumberOptimal(new int[]{1}));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1)
                return key;
        }

        return -1;
    }

    public static int singleNumberOptimal(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }

    public static int singleNumberIIOptimal(int[] nums) {
        int xor = 0;
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (!list.contains(num))
                xor ^= num;
        }

        return xor;
    }
}
