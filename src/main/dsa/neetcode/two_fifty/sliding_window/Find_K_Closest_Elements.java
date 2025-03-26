package src.main.dsa.neetcode.two_fifty.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class Find_K_Closest_Elements {

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1}, 1, 1));
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(findClosestElements(new int[]{1, 1, 2, 3, 4, 5}, 4, -1));
        System.out.println(findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        for (int i = left; i <= right; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
