package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// revision needed
public class D012_Max_Circular_Subarray_Sum {

    public static void main(String[] args) {
//        System.out.println(circularSubarraySum(new int[] {8, -8, 9, -9, 10, -11, 12}));
//        System.out.println(circularSubarraySum(new int[] {10, -3, -4, 7, 6, 5, -4, -1}));
//        System.out.println(circularSubarraySumV2(new int[] {10, -3, -4, 7, 6, 5, -4, -1}));
//        System.out.println(circularSubarraySumV3(new int[] {10, -3, -4, 7, 6, 5, -4, -1}));
//        System.out.println(circularSubarraySumV3(new int[] {-2, -4, -1}));
        System.out.println(circularSubarraySumV2(new int[]{-7, 32, -11, 21, 18, 35, -26, -17, 35, -12, -38, -33, 32, 16, 44, 11, -40, -21, 2, 27, -35, 21, -37, -12, 1}));
        System.out.println(circularSubarraySumV3(new int[]{-7, 32, -11, 21, 18, 35, -26, -17, 35, -12, -38, -33, 32, 16, 44, 11, -40, -21, 2, 27, -35, 21, -37, -12, 1}));
        System.out.println(circularSubarraySumV4(new int[]{-7, 32, -11, 21, 18, 35, -26, -17, 35, -12, -38, -33, 32, 16, 44, 11, -40, -21, 2, 27, -35, 21, -37, -12, 1}));
        System.out.println(circularSubarraySumV2(new int[]{10, -3, -4, 7, 6, 5, -4, -1}));
        System.out.println(circularSubarraySumV3(new int[]{10, -3, -4, 7, 6, 5, -4, -1}));
        System.out.println(circularSubarraySumV4(new int[]{10, -3, -4, 7, 6, 5, -4, -1}));
        System.out.println(circularSubarraySumV2(new int[]{-5, 0, 8, 1, 3, 20, 3, -9}));
        System.out.println(circularSubarraySumV3(new int[]{-5, 0, 8, 1, 3, 20, 3, -9}));
        System.out.println(circularSubarraySumV4(new int[]{-5, 0, 8, 1, 3, 20, 3, -9}));
        System.out.println(circularSubarraySumV4(new int[]{-5, -1, -9}));
//        System.out.println(circularSubarraySum(new int[] {-1, 40, -14, 7, 6, 5, -4, -1}));
    }

    public static int circularSubarraySum(int[] arr) {
        int sum = 0;
        int lowest = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            sum += ele;
        }
        for (Map.Entry<Integer, Integer> elements : map.entrySet()) {
            if (elements.getValue() == 1 && elements.getKey() < lowest) {
                lowest = elements.getKey();
            }
        }
        return sum - lowest;
    }

    public static int circularSubarraySumV2(int[] arr) {
        int n = arr.length;
        int res = arr[0];

        // Subarray that starts with index i
        for (int i = 0; i < n; i++) {
            int currSum = 0;

            // Considering all possible endpoints of the
            // Subarray that begins with index i
            for (int j = 0; j < n; j++) {

                // Circular index
                int idx = (i + j) % n;
                currSum = currSum + arr[idx];
                res = Math.max(res, currSum);
            }
        }

        return res;
    }

    public static int circularSubarraySumV3(int[] arr) {
        int res = 0;
        int tempPreSum = 0;
        int minPreSum = 0;
        for (int i : arr) {
            tempPreSum += i;
            res += i;
            if (tempPreSum >= 0) {
                tempPreSum = 0;
            } else {
                minPreSum = Math.min(tempPreSum, minPreSum);
            }
        }
        return res - minPreSum;
    }

    public static int circularSubarraySumV4(int[] arr) {
        int totalSum = 0;
        int currMaxSum = 0, currMinSum = 0;
        int maxSum = arr[0], minSum = arr[0];

        for (int i = 0; i < arr.length; i++) {

            // Kadane's to find maximum sum subarray
            currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currMaxSum);

            // Kadane's to find minimum sum subarray
            currMinSum = Math.min(currMinSum + arr[i], arr[i]);
            minSum = Math.min(minSum, currMinSum);

            // Sum of all the elements of input array
            totalSum += arr[i];
        }

        // If the minimum subarray is equal to total Sum
        // then we just need to return normalSum
        if (minSum == totalSum)
            return maxSum;

        int circularSum = totalSum - minSum;
        return Math.max(maxSum, circularSum);
    }
}
