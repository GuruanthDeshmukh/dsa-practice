package src.main.dsa.neetcode.two_fifty.two_pointer;

import java.util.Arrays;

public class Boats_to_Save_People {

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        System.out.println(numRescueBoats(new int[]{5, 1, 4, 2}, 6));
        System.out.println(numRescueBoats(new int[]{2, 4}, 5));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            int sum = people[left] + people[right];
            if (sum > limit) {
                res++;
                right--;
            } else {
                res++;
                left++;
                right--;
            }
        }
        return res;
    }
}
