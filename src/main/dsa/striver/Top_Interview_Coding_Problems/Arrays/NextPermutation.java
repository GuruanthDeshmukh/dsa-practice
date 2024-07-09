package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = new int[]
//                {1,3,2};
                {2, 1, 5, 4, 3, 0, 0};
        Arrays.stream(arr).sequential().forEach(value -> System.out.print(value + " "));
        System.out.println();
        nextPermutation(arr);
        Arrays.stream(arr).sequential().forEach(value -> System.out.print(value + " "));
    }

    /**
     * <a href="https://www.youtube.com/watch?v=IhsUbEMfIbY">Solution Video</a>
     * <a href="https://www.youtube.com/watch?v=JDOXKqF60RQ">Striver's Videos</a>
     *
     * @param nums Input Number
     */
    public static void nextPermutation(int[] nums) {
        int index = nums.length - 2;
        if (index >= 0) {
            while (index >= 0 && nums[index] >= nums[index + 1]) {
                index--;
            }
            if (index >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[j] <= nums[index]) {
                    j--;
                }
                swap(nums, index, j);
            }
            sort(nums, index + 1);
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
