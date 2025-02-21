package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

import java.util.Arrays;

public class Concatenation_of_Array {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 3, 2, 1})));
    }

    public static int[] getConcatenation(int[] nums) {
        int[] res = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i + nums.length] = nums[i];
        }
        return res;
    }
}
