package src.main.dsa.striver.a2zdsa.arrays.easy;

public class P001LargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(largest(new int[]{1, 2, 0, 3, 2, 4, 5}, 0));
    }

    public static int largest(int[] arr, int n) {
        int largest = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > largest)
                largest = i;
        }

        return largest;
    }
}
