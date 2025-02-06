package src.main.dsa.work_tech;

import java.util.Arrays;

public class P005ImplementInsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 5, 3, 1};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr) {
        // add your logic here
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
