package src.main.dsa.striver.a2zdsa.binary_search.lec1;

import java.util.Arrays;

public class P005FloorAndCeilInSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10}, 6, 5)));
        System.out.println(Arrays.toString(getFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10}, 6, 8)));
        System.out.println(Arrays.toString(getFloorAndCeil(new int[]{3, 4, 4, 7, 8, 10}, 6, 2)));
        System.out.println(Arrays.toString(getFloorAndCeil(new int[]{2}, 1, 23)));
        System.out.println(Arrays.toString(getFloorAndCeil(new int[]{5, 7, 7, 12, 22, 28, 29}, 7, 30)));
    }

    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        // Wriute your code here.
        if (a.length == 1)
            return a[0] <= x ? new int[]{a[0], -1} : new int[]{-1, a[0]};
        int[] res = new int[]{-1, -1};
        int start = 0;
        int end = n;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == n)
                break;

            if (a[mid] == x) {
                res[0] = a[mid];
                res[1] = a[mid];
                break;
            } else if (a[mid] < x) {
                res[0] = a[mid];
                start = mid + 1;
            } else {
                res[1] = a[mid];
                end = mid - 1;
            }
        }
        return res;
    }
}
