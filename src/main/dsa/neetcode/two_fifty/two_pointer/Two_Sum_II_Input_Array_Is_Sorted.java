package src.main.dsa.neetcode.two_fifty.two_pointer;

import java.util.Arrays;

public class Two_Sum_II_Input_Array_Is_Sorted {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            }
        }
        return res;
    }
}
