package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

import java.util.Arrays;

public class Products_of_Array_Except_Self {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 0, 1, 2, 3})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{4, 3, 2, 1, 2})));
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1)
            return nums;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int prefixProduct = 1;
        int suffixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - 1 - i];
            prefix[i] = prefixProduct;
            suffix[nums.length - 1 - i] = suffixProduct;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                res[i] = suffix[1];
            else if (i == nums.length - 1)
                res[i] = prefix[nums.length - 2];
            else
                res[i] = prefix[i - 1] * suffix[i + 1];
        }
        return res;
    }

//    public static int[] productExceptSelfV2(int[] nums) {
//        if (nums.length <= 1)
//            return nums;
//        int[] res = new int[nums.length];
//        for (int i = 1; i < nums.length; i++) {
//            res[i]
//        }
//    }
}
