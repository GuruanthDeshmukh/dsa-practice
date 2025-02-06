package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

public class D001_Second_Largest {
    public static void main(String[] args) {
        System.out.println(getSecondLargest(new int[]{12, 35, 1, 10, 34, 1}));
        System.out.println(getSecondLargest(new int[]{10, 5, 10}));
        System.out.println(getSecondLargest(new int[]{10, 10, 10}));
    }

    public static int getSecondLargest(int[] arr) {
        // Code Here
        if (arr.length < 1)
            return -1;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > largest) {
                secondLargest = largest;
                largest = i;
            } else if (i > secondLargest && i != largest) {
                secondLargest = i;
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}
