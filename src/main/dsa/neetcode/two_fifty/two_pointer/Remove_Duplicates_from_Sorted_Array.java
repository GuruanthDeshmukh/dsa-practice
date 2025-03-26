package src.main.dsa.neetcode.two_fifty.two_pointer;

public class Remove_Duplicates_from_Sorted_Array {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        int x = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[x] = nums[i - 1];
                x++;
            }
        }
        return 0;
    }
}
