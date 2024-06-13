package src.main.dsa.striver.Top_Interview_Coding_Problems.Arrays2;

import java.util.Vector;

public class CountInversions {
    public static void main(String[] args) {
        long[] arr = new long[]{
                2, 5, 1, 3, 4
//                52244275,123047899,493394237,922363607,378906890,188674257,222477309,902683641,860884025,339100162
        };
        System.out.println(getInversionsV2(arr, arr.length));
    }

    public static long getInversions(long[] arr, int n) {
        long response = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] > arr[j] && i < j)
                    response++;
            }
        }

        return response;
    }

    public static long getInversionsV2(long[] arr, int n) {
        if (1 == arr.length)
            return 1;

        return mergeSort(arr, 0, n - 1);
    }

    private static long mergeSort(long[] arr, int low, int high) {

        if (low >= high)
            return 0;

        long result = 0;
        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        result += merge(arr, low, mid, high);
        return result;
    }

    private static long merge(long[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        long count = 0;

        Vector<Long> tmp = new Vector<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
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
        for (int j = low; j <= high; j++) {
            arr[j] = tmp.get((j - low));
            count++;
        }
        return count;
    }

}
