package src.main.dsa.striver.a2zdsa.binary_search.lec1;

import java.util.Arrays;

public class P003CeilTheFloor {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFloorAndCeil(7, new int[]{5, 6, 8, 9, 6, 5, 5, 6})));
        System.out.println(Arrays.toString(getFloorAndCeil(10, new int[]{5, 6, 8, 8, 6, 5, 5, 6})));
    }

    public static int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int[] res = new int[]{-1, -1};
        int low = 0;
        int end = arr.length - 1;
        while (low <= end) {
            int mid = (low + end) / 2;
            if (arr[mid] <= x) {
                res[0] = arr[mid];
                low = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        low = 0;
        end = arr.length - 1;
        while (low <= end) {
            int mid = (low + end) / 2;
            if (arr[mid] >= x) {
                res[1] = arr[mid];
                end = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
