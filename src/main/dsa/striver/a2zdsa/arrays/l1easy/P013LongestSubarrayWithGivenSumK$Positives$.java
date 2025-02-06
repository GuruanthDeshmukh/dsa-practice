package src.main.dsa.striver.a2zdsa.arrays.l1easy;

import java.util.HashMap;
import java.util.Map;

public class P013LongestSubarrayWithGivenSumK$Positives$ {

    public static void main(String[] args) {
//        System.out.println(lenOfLongSubarrV2(new int[]{-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6}, 17, 15));
        System.out.println(lenOfLongSubarrV3(new int[]{-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6}, 17, 15));
//        System.out.println(lenOfLongSubarrV2(new int[]{4,1,1,1,2,3,5}, 7, 5));
    }//5

    public static int lenOfLongSubarr(int[] A, int N, int K) {
        //Complete the function

        if (N == 0) {
            return 0;
        }
        int currentSum = 0;
        int len = 0;
        int i, j;
        i = j = 0;

        while (i < N && j < N) {
            if (K < currentSum) {
                currentSum -= A[i];
                i++;
                continue;
            } else if (K > currentSum) {
                currentSum += A[j];
                if (0 > currentSum) {
                    currentSum = 0;
                    i++;
                }
                j++;
                continue;
            } else {
                len = Math.max(len, j - i);
                j++;
                continue;
            }
        }
        return len;
    }

    public static int lenOfLongSubarrV2(int[] A, int N, int K) {
        int left = 0, right = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (right < N) {
            sum += A[right];
            if (0 > sum) {
                sum = 0;
                left = right;
                right++;
            } else if (K == sum) {
                max = Math.max(max, right - left + 1);
                right++;
            } else if (sum < K) {
                right++;
            } else {
                while (left < right && sum >= K) {
                    if (sum > K) {
                        sum -= A[left];
                        left++;
                    } else {
                        max = Math.max(max, right - left + 1);
                        right++;
                    }
                }
            }
        }
        return max;
    }

    public static int lenOfLongSubarrV3(int[] A, int N, int K) {
        int prefixSum = 0, len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            prefixSum += A[i];
            System.out.println("i : " + i + " prefix sum : " + prefixSum);
            if (prefixSum == K) {
                len = Math.max(len, i + 1);
            }
            if (map.containsKey(prefixSum - K)) {
                len = Math.max(i - map.get(prefixSum - K), len);
                System.out.println("Len : " + len);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return len;
    }

}
