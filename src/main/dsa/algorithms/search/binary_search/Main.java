package src.main.dsa.algorithms.search.binary_search;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{
                3, 2, 1, 4, 1, 5, 2, 6, 4
//                -1,0,3,5,9,12
//                5
        };
        Arrays.sort(arr);
        Arrays.stream(arr).sequential().forEach(element -> System.out.print(element + " "));
        System.out.println();
//        Do change target
        System.out.println(binarySearchMyUnderstanding(arr, 0, arr.length -1, 5));
        System.out.println(binarySearch(arr, 0, arr.length -1, 5));
    }

    /*
     * Implementation based on my understanding of below video
     * Video reference : https://www.youtube.com/watch?v=MHf6awe89xw&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=5
     *   Striver's Binary Search.
     *
     * */
    private static boolean binarySearchMyUnderstanding(int[] arr, int start, int end, int target) {

        //start crossed end, we are supposed to stop and element is missing
        if (start > end)
            return false;

        int mid = (start + end) / 2;

        //if target is at mid position
        if (target == arr[mid])
            return true;
            //target is in right half of array
        else if (target > arr[mid])
            return binarySearchMyUnderstanding(arr, mid + 1, end, target);

        //target is in left half of array, default condition
        return binarySearchMyUnderstanding(arr, start, mid - 1, target);

    }

    /*
    * Implementing approach of mentioned in video
    * */
    public static int binarySearch (int[] arr, int start, int end, int target) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;

        if (target == arr[mid])
            return mid;
        else if (target > arr[mid])
            return binarySearch(arr, mid + 1, end, target);

        return binarySearch(arr, start, mid - 1, target);
    }
}
