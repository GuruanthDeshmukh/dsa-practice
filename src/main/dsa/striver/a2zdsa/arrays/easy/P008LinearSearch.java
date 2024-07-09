package src.main.dsa.striver.a2zdsa.arrays.easy;

public class P008LinearSearch {

    public static void main(String[] args) {
        System.out.println(searchInSorted(new int[]{1, 2, 3, 4, 6}, 5, 6));
        System.out.println(searchInSortedV2(new int[]{1, 2, 3, 4, 6}, 5, 8));
    }

    public static int searchInSorted(int[] arr, int N, int K) {
        for (int i : arr) {
            if (i == K)
                return 1;
        }
        return -1;
    }

    public static int searchInSortedV2(int[] arr, int N, int K) {
        return performBinarySearch(arr, 0, N - 1, K);
    }

    private static int performBinarySearch(int[] arr, int start, int end, int k) {
        int mid = (start + end) / 2;
        if (start >= end) {
            if (k == arr[mid])
                return 1;
            else
                return -1;
        }
        if (k == arr[mid])
            return 1;
        else if (k < arr[mid]) {
            return performBinarySearch(arr, 0, mid, k);
        } else {
            return performBinarySearch(arr, mid + 1, end, k);
        }
    }
}
