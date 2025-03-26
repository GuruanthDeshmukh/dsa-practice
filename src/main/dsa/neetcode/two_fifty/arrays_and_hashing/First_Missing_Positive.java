package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

public class First_Missing_Positive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositiveV2(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositiveV2(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositiveV2(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositiveV2(new int[]{1}));
        System.out.println(firstMissingPositiveV2(new int[]{1, 1}));
    }

    public static int firstMissingPositive(int[] nums) {
        int smallest = 1;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] > 0 && nums[index] == smallest) {
                smallest = nums[index] + 1;
                nums[index] = 0;
                index = 0;
            } else {
                index++;
            }
        }
        return smallest;
    }

    public static int firstMissingPositiveV2(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            while (nums[index] < nums.length && nums[index] > 0 && nums[nums[index] - 1] != nums[index]) {
                int temp = nums[index];
                nums[index] = nums[nums[index] - 1];
                nums[temp - 1] = temp;
            }
            index++;
        }
        index = 0;
        while (index < nums.length) {
            if (nums[index] != index + 1)
                return index + 1;
            index++;
        }
        return index + 1;
    }
}
