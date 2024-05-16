package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays4;

public class CountNumberOfSubarraysWithGivenXorK {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{4, 2, 2, 6, 4}, 6));
    }

    /**
     * Brute force approach
     *
     * @param A Array of numbers
     * @param B Target
     * @return Number of sub-arrays where XOR of elements in B.
     */
    public static int solve(int[] A, int B) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            long xor = 0;
            for (int j = i; j < A.length; j++) {
                xor ^= A[j];
                if (B == xor) {
                    count++;
                }
            }
        }
        int temp = 0;
        System.out.println();
        for (int i = 0; i < A.length; i++) {
            temp ^= A[i];
            System.out.println(" n : " + i + " value : " + temp);
        }

        return count;
    }

    public static int solveV2(int[] A, int B) {
        int count = 0;


        return count;
    }
}
