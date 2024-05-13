package src.main.dsa.algorithms.sort.merge_sort;

import java.util.Arrays;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 4, 1, 5, 2, 6, 4};
        //starting merge sort from starting element (o) to last element (n-1, n being size)
        mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).sequential().forEach(System.out::println);
    }
    /**
    * Video reference : https://www.youtube.com/watch?v=AseUmwVNaoY
    *   Striver's Merge Sort.
    *
    * We divide array in 2 halves upto atomic level
    * Then we start merging as per their order
    */
    private static void mergeSort(int[] arr, int low, int high) {

        //base condition
        if (low >= high)
            return;

        int mid = (low + high) / 2;

        //dividing array in left half
        mergeSort(arr, low, mid);
        //dividing array in right half
        mergeSort(arr, mid + 1, high);
        //merging
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;

        //declaring and adding data in temporary storage.
        Vector<Integer> tmp = new Vector<>(low + high);
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                tmp.add(arr[left]);
                left++;
            } else {
                tmp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            tmp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            tmp.add(arr[right]);
            right++;
        }

        //updating the original array with sorted data
        for (int j = low; j <= high; j++) {
            arr[j] = tmp.get(j - low);
        }
    }
}
