package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement$n_3times {

    public static void main(String[] args) {
        List<Integer> list = majorityElementV2(new int[]
//                {3,2,3}
                        {1, 2}
//                        {2,2}
        );

        list.forEach(element -> System.out.print(element + " "));
    }

    /**
     * Brute for using HashMap to store the frequency of elements
     * If element count is greater than array length by 3 and is not present in a response list
     *
     * @param arr Array
     * @return List of numbers with frequency more than n/3
     */
    public static List<Integer> majorityElement(int[] arr) {
        List<Integer> result = new ArrayList<>(arr.length);
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (!result.contains(num) && map.get(num) > arr.length / 3)
                result.add(num);
        }

        return result;
    }

    /**
     * Usage of Moore's Voting Algorithm
     * <a href="https://www.youtube.com/watch?v=vwZj1K0e9U8">Solution Video</a>
     *
     * @param arr Input array
     * @return List of elements with count more than n/3
     */
    public static List<Integer> majorityElementV2(int[] arr) {

        List<Integer> result = new ArrayList<>(2);

        int count1 = 0;
        int count2 = 0;
        int element1 = 0;
        int element2 = 0;

        for (int element : arr) {
            if (0 == count1 && element != element2) {
                count1++;
                element1 = element;
            } else if (0 == count2 && element != element1) {
                count2++;
                element2 = element;
            } else if (element == element1) {
                count1++;
            } else if (element == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int element : arr) {
            if (element == element1) {
                count1++;
            } else if (element == element2) {
                count2++;
            }

            if (count1 > arr.length / 3 && !result.contains(element1)) {
                result.add(element1);
            } else if (count2 > arr.length / 3 && !result.contains(element2)) {
                result.add(element2);
            }
        }

        return result;
    }

}
