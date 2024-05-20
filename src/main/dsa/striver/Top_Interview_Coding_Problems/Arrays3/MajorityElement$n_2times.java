package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays3;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement$n_2times {

    public static void main(String[] args) {
//        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElementV2(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     * Brute force done using HashMaps.
     *
     * @param arr Input array
     * @return element with the majority
     */
    public static int majorityElement(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > arr.length / 2)
                return num;
        }
        return 0;
    }

    /**
     * Optimal method using Moore's Voting Algorithm for identifying an element suitable for a majority.
     * The iterating the array to decide if that element is the majority or not.
     * <a href="https://www.youtube.com/watch?v=nP_ns3uSh80">Solution Video</a>
     *
     * @param arr Input array
     * @return element with the majority
     */
    public static int majorityElementV2(int[] arr) {
        int candidate = 0;
        int count = 0;
        int index = 0;
        while (index < arr.length) {
            if (count == 0) {
                candidate = arr[index];
            }
            if (candidate == arr[index]) {
                count++;
            } else {
                count--;
            }
            index++;
        }

        int candidateCount = 0;
        for (int element : arr) {
            if (element == candidate) {
                candidateCount++;
            }
        }

        if (candidateCount > arr.length / 2)
            return candidate;

        return 0;
    }
}
