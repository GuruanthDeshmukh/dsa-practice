package src.main.dsa.striver.a2zdsa.arrays.l1easy;

import java.util.Arrays;

public class P005LeftRotateAnArrayByOnePlace {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        rotate(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums) {
        int temp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = temp;
    }

}
