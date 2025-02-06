package src.main.dsa.striver.a2zdsa.binary_search.lec1;

public class P002FloorInASortedArray {

    public static void main(String[] args) {
        System.out.println(findFloor(new int[]{1, 2, 8, 10, 11, 12, 19}, 0));
        System.out.println(findFloorV2(new int[]{1, 2, 8, 10, 11, 12, 19}, 0));
        System.out.println(findFloor(new int[]{1, 2, 8, 10, 11, 12, 19}, 5));
        System.out.println(findFloorV2(new int[]{1, 2, 8, 10, 11, 12, 19}, 5));
        System.out.println(findFloor(new int[]{1, 2, 8}, 1));
        System.out.println(findFloorV2(new int[]{1, 2, 8}, 1));
    }

    public static int findFloor(int[] arr, int k) {
        // write code here
        int ans = -1;
        int low, high;
        low = 0;
        high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static int findFloorV2(int[] arr, int k) {
        int ans = -1;
        int low = 0;
        int end = arr.length - 1;

        while (low <= end) {
            int mid = (low + end) / 2;
            if (arr[mid] <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
