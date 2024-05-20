package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays3;

public class ReversePairs {

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1, 2, 3, 4}));
    }

    /**
     * Brute force
     *
     * @param arr Input array
     * @return count of reverse pairs (pairs such that number 1 > 2 * number 2)
     */
    public static int reversePairs(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2L * arr[j])
                    count++;
            }
        }
        return count;
    }


}
