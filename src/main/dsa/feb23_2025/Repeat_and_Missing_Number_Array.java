package src.main.dsa.feb23_2025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Repeat_and_Missing_Number_Array {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(repeatedNumber(new int[] {3, 1, 2, 5, 3})));
    }

    public static int[] repeatedNumber(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        int arraySum = 0;
        for (int j : arr) {
            arraySum += j;
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            if (value == 2) {
                arraySum -= integerIntegerEntry.getKey();
                res[0] = integerIntegerEntry.getKey();
            }
        }
        int sum = n * (n + 1) / 2;
        res[1] = sum - arraySum;
        return res;
    }
}
