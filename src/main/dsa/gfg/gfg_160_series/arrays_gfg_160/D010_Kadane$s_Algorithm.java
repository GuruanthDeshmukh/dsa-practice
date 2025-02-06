package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

public class D010_Kadane$s_Algorithm {

    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{2, 3, -8, 7, -1, 2, 3})); // 11
        System.out.println(maxSubarraySum(new int[]{-2, -4}));
        System.out.println(maxSubarraySum(new int[]{5, 4, 1, 7, 8}));
    }

    public static int maxSubarraySum(int[] arr) {
        int sum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int num : arr) {
            tempSum += num;
            sum = Math.max(sum, tempSum);
            if (tempSum < 0) {
                tempSum = 0;
            }

        }
        return sum;
    }

}
