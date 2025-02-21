package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

public class Majority_Element {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majorityElement(int[] arr) {
        int majorityElement = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == majorityElement)
                count++;
            else
                count--;
            if (count == 0) {
                majorityElement = arr[i];
                count = 1;
            }
        }
        return majorityElement;
    }

}
