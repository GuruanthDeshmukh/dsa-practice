package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2};
        Arrays.stream(arr).sequential().forEach(value -> System.out.print(value + " "));
        System.out.println();
        nextPermutation(arr);
        Arrays.stream(arr).sequential().forEach(value -> System.out.print(value + " "));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length-2;
        if (i>=0) {
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
            sort(nums, i+1);
        } else {
            sort(nums,0);
        }
    }

    private static void sort(int[] nums, int start) {
        int end = nums.length-1;
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
