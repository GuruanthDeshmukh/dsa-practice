package src.main.dsa.striver.a2zdsa.binary_search.lec1;

public class P004SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsertV2(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsertV2(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsertV2(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(searchInsertV2(new int[]{1, 3, 5, 6}, 0));
        System.out.println(searchInsert(new int[]{1, 3}, 3));
        System.out.println(searchInsertV2(new int[]{1, 3}, 3));
    }

    public static int searchInsert(int[] nums, int target) {
        int ans = -1;
        int low = 0;
        int end = nums.length - 1;

        if (nums[0] >= target)
            return 0;

        if (nums[nums.length - 1] < target)
            return nums.length;

        if (nums[nums.length - 1] == target)
            return nums.length - 1;

        while (low <= end) {
            int mid = (low + end) / 2;
            if (nums[mid] < target) {
                ans = mid + 1;
                low = mid + 1;
            } else if (nums[mid] == target) {
                ans = mid;
                break;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static int searchInsertV2(int[] nums, int target) {
        int low = 0;
        int end = nums.length - 1;

        while (low <= end) {
            int mid = (low + end) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }
}
