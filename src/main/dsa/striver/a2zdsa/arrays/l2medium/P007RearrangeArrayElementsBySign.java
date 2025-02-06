package src.main.dsa.striver.a2zdsa.arrays.l2medium;

import java.util.Arrays;

public class P007RearrangeArrayElementsBySign {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31})));
        System.out.println(Arrays.toString(rearrangeArrayV2(new int[]{28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31})));
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int[] positives = new int[nums.length / 2];
        int[] negatives = new int[nums.length / 2];
        int posiIndex = 0;
        int negIndex = 0;
        for (int num : nums) {
            if (num < 0) {
                negatives[negIndex] = num;
                negIndex++;
            } else {
                positives[posiIndex] = num;
                posiIndex++;
            }
        }
        posiIndex = 0;
        negIndex = 0;
        int index = 0;
        while (index < nums.length) {
            if (index % 2 == 0) {
                res[index] = positives[posiIndex];
                posiIndex++;
            } else {
                res[index] = negatives[negIndex];
                negIndex++;
            }
            index++;
        }
        return res;
    }

    public static int[] rearrangeArrayV2(int[] nums) {
        int[] res = new int[nums.length];
        int posIndex = 0, negIndex = 1;
        int index = 0;
        while (index < nums.length) {
            int num = nums[index];
            if (num > 0 && posIndex < nums.length) {
                res[posIndex] = num;
                posIndex += 2;
            } else if (num < 0 && negIndex < nums.length) {
                res[negIndex] = num;
                negIndex += 2;
            }
            index++;
        }

//        while (posIndex < nums.length) {
//            res[posIndex] = nums[index];
//            index++;
//            posIndex += 2;
//        }
//
//        while (negIndex < nums.length) {
//            res[negIndex] = nums[index];
//            index++;
//            negIndex += 2;
//        }
        return res;
    }

}
