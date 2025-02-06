package src.main.dsa.gfg.problems;

public class CountOfSubarraysWithSumAtleastK {

    public static void main(String[] args) {
        System.out.println(countOfSubarraysWithSumAtleastK(new int[]{6, 1, 2, 7}, 4));
        System.out.println(countOfSubarraysWithSumAtleastK(new int[]{6, 1, 2, 7}, 10));
        System.out.println(countOfSubarraysWithSumAtleastK(new int[]{3, 3, 3}, 5));
    }

    public static int countOfSubarraysWithSumAtleastK(int[] arr, int k) {
        int res, i, j;
        res = i = j = 0;
        int sum = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (sum >= k) {
                res += arr.length - j;
            }
            while (sum >= k) {
                sum -= arr[i];
                i++;
                if (sum >= k) {
                    res++;
                }
            }
            j++;
        }
        return res;
    }
}
