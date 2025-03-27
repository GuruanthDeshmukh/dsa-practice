package src.main.dsa.feb23_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interview_ThreeSum {
    public static void main(String[] args) {
        int arr[] = new int[] {5, 6, 9, 11, 15, 7, 4};
        int k = 16;

        System.out.println(triplets(arr, k));
    }

    private static List<List<Integer>> triplets(int[] arr, int k) {
        List<List<Integer>> resp = new ArrayList<>();
        Arrays.sort(arr);
        int a = 0;
        while (a < arr.length-2) {
            int b = a + 1;
            int c = arr.length-1;
            while (b < c) {
                int sum = arr[a]+arr[b]+arr[c];
                if (sum > k)
                    c--;
                else if (sum < k)
                    b++;
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[a]);
                    temp.add(arr[b]);
                    temp.add(arr[c]);
                    resp.add(temp);
                    b++;
                }
            }
            a++;
        }
        return resp;
    }
}
