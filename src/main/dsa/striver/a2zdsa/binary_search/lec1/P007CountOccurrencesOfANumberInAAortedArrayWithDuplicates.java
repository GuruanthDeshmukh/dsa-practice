package src.main.dsa.striver.a2zdsa.binary_search.lec1;

public class P007CountOccurrencesOfANumberInAAortedArrayWithDuplicates {

    public static void main(String[] args) {
//        System.out.println(countFreq(new int[]{1, 1, 2, 2, 2, 2, 3}, 2));
//        System.out.println(countFreq(new int[]{1, 1, 2, 2, 2, 2, 3}, 4));
//        System.out.println(countFreq(new int[]{8,9,10,12,12,12}, 12));
        System.out.println(countFreq(new int[]{10, 11}, 10));
    }

    static int countFreq(int[] arr, int target) {
        // code here
        int res = 0;

        int low = 0;
        int high = arr.length - 1;
        int temp = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid >= arr.length)
                break;

            if (arr[mid] == target) {
                temp = mid;
                break;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (temp == -1)
            return res;

        for (int i = temp; i < arr.length - 1 && arr[i] == arr[i + 1]; i++) {
            res++;
        }

        for (int i = temp; i > 0 && arr[i] == arr[i - 1]; i--) {
            res++;
        }

        return res + 1;
    }
}
