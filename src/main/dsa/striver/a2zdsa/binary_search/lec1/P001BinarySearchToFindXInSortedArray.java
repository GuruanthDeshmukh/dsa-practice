package src.main.dsa.striver.a2zdsa.binary_search.lec1;

public class P001BinarySearchToFindXInSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] < target) {
            start = mid + 1;
            return binarySearch(nums, start, end, target);
        }
        end = mid - 1;
        return binarySearch(nums, start, end, target);
    }

    private static int binarySearchV2(int[] nums, int start, int end, int target) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return binarySearch(nums, start, mid - 1, target);
        }
    }
}
