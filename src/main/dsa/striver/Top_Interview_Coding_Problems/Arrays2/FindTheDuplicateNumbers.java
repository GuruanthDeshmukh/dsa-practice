package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays2;

import java.util.HashMap;
import java.util.Map;

public class FindTheDuplicateNumbers {
    public static void main(String[] args) {
        System.out.println(findDuplicate2(new int[]{1, 3, 4, 2, 2}));
    }

    public static int findDuplicate(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int element : nums) {
            if (null == map.get(element)) {
                map.put(element, 1);
            } else {
                result = element;
            }
        }
        return result;
    }

    public static int findDuplicate2(int[] nums) {
        int slowPointer = 0;
        int fastPointer = 0;

        do {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        } while (slowPointer != fastPointer);

        fastPointer = 0;
        while (slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }

        return slowPointer;
    }

}
