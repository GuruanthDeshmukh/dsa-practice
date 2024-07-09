package src.main.dsa.striver.a2zdsa.arrays.easy;

public class P013LongestSubarrayWithGivenSumK$Positives$ {

    public static void main(String[] args) {
        System.out.println(lenOfLongSubarr(new int[]{-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6}, 17, 15));
    }

    public static int lenOfLongSubarr(int[] A, int N, int K) {
        //Complete the function

        if (N == 0) {
            return 0;
        }
        int currentSum = 0;
        int len = 0;
        int i, j;
        i = j = 0;

//        while (j<N && i<N) {
//            if (K < currentSum) {
//                currentSum -= A[i];
//                i++;
//                continue;
//            }
//            currentSum += A[j];
//            if (currentSum < 0) {
//                currentSum = 0;
//                i=j+1;
//            } else if (K == currentSum) {
//                len = Math.max(len, j - i + 1);
//            }
//            j++;
//        }

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
}
