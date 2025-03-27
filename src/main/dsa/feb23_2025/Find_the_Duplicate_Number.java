package src.main.dsa.feb23_2025;

import java.util.HashSet;

public class Find_the_Duplicate_Number {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] {1,3,4,2,2}));
        System.out.println(findDuplicateV2(new int[] {1,3,4,2,2}));
    }

    public static int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i))
                return i;
        }
        return -1;
    }

//    public static int findDuplicateV2(int[] nums) {
//        // Step 1: Initialize the tortoise and hare
//        int tortoise = nums[0];
//        int hare = nums[0];
//
//        // Step 2: Find the intersection point in the cycle
//        do {
//            tortoise = nums[tortoise]; // Move tortoise by 1 step
//            hare = nums[nums[hare]];    // Move hare by 2 steps
//        } while (tortoise != hare);
//
//        // Step 3: reset the tortoise to start and move both tortoise and hare simultaneously to find duplicates
//        //Find the entrance to the cycle
//        tortoise = nums[0]; // Start from the beginning
//        while (tortoise != hare) {
//            tortoise = nums[tortoise]; // Move tortoise by 1 step
//            hare = nums[hare];          // Move hare by 1 step
//        }
//
//        // The point where they meet is the duplicate number
//        return hare;
//    }

    public static int findDuplicateV2(int[] arr) {
        int hare = arr[0];
        int tortoise = arr[0];
        do {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        } while (tortoise != hare);

        tortoise = arr[0];
        while (tortoise != hare) {
            tortoise = arr[tortoise];
            hare = arr[hare];
        }

        return hare;
    }

}
