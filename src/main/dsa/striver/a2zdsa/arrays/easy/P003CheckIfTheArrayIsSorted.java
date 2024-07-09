package src.main.dsa.striver.a2zdsa.arrays.easy;

public class P003CheckIfTheArrayIsSorted {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 10, 6};
        System.out.println(check(arr));
    }

    public static boolean check(int[] nums) {
        int check = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i])
                check++;
        }

        if (nums[0] <= nums[nums.length - 1])
            check++;

        return check <= 1;
    }
}
