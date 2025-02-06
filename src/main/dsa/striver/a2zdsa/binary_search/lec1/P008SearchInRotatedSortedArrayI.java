package src.main.dsa.striver.a2zdsa.binary_search.lec1;

public class P008SearchInRotatedSortedArrayI {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{3, 5, 1}, 3));
        System.out.println(search(new int[]{5, 1, 3}, 5));
    }

    public static int search(int[] nums, int target) {
        int res = -1;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high && high < nums.length) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                res = mid;
                break;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[mid] > target && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        if (nums[mid] == target) {
            res = mid;
        }
        return res;
    }
}
