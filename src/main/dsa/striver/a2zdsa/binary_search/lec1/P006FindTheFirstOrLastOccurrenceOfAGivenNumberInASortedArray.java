package src.main.dsa.striver.a2zdsa.binary_search.lec1;

import java.util.Arrays;

public class P006FindTheFirstOrLastOccurrenceOfAGivenNumberInASortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 4}, 4)));
    }

    public static int[] searchRange(int[] a, int x) {
        // Wriute your code here.
        if (a.length == 1)
            return fetchFirstAndLastIndex(a, a[0] == x ? 0 : -1);

        int n = a.length - 1;
        int[] res = new int[]{-1, -1};
        int start = 0;
        int end = n;
        int count = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid > n)
                break;

            if (a[mid] == x) {
                return fetchFirstAndLastIndex(a, mid);
            } else if (a[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    private static int[] fetchFirstAndLastIndex(int[] a, int index) {
        int[] res = new int[2];
        int temp = index;
        while (temp >= 0 && (temp - 1 >= 0) && a[temp] == a[temp - 1])
            temp--;
        res[0] = temp;
        temp = index;
        while (res[0] != -1 && temp < a.length && (temp + 1 < a.length) && a[temp] == a[temp + 1])
            temp++;
        res[1] = temp;
        return res;
    }

}
