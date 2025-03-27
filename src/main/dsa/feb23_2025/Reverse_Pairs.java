package src.main.dsa.feb23_2025;

import java.util.ArrayList;

public class Reverse_Pairs {

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1,3,2,3,1}));
    }

    public static int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length-1);
    }

    private static int merge(int[] nums, int start, int end) {
        if (start >= end)
            return 0;

        int mid = (start + end) / 2;
        int resp = 0;
        resp += merge(nums, start, mid);
        resp += merge(nums, mid+1, end);
        resp += mergeSort(nums, start, mid, end);
        return resp;
    }

    private static int mergeSort(int[] nums, int start, int mid, int end) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = start;
        int right = mid + 1;
        int res = 0;
        for (int i = left; i <= mid; i++) {
            while (right <= end && nums[i] > 2*nums[right]) {
                right++;
            }
            res += right-mid-1;
        }
        right = mid+1;
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
                list.add(nums[left]);
                left++;
        }
        while (right <= end) {
                list.add(nums[right]);
                right++;

        }

        for (int i = start; i <= end; i++) {
            nums[i] = list.get(i-start);
        }

        return res;
    }
}
