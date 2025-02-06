package src.main.dsa.gfg.problems;

public class KthElementOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(kthElement(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}, 5));
        System.out.println(kthElement(new int[]{100, 112, 256, 349, 770}, new int[]{72, 86, 113, 119, 265, 445, 892}, 7));
        System.out.println(kthElement(new int[]{1, 1, 2}, new int[]{1, 1, 2}, 5));
    }

    public static int kthElement(int[] a, int[] b, int k) {
        // code here
        int[] arr = new int[k + 1];
        int i = 0, j = 0, index = 0;
        while (i < a.length && j < b.length && index < k) {
            if (a[i] <= b[j]) {
                arr[index] = a[i];
                i++;
            } else {
                arr[index] = b[j];
                j++;
            }
            index++;
        }
        while (i < a.length && index < k) {
            arr[index] = a[i];
            i++;
            index++;
        }
        while (j < b.length && index < k) {
            arr[index] = b[j];
            j++;
            index++;
        }
        return arr[index - 1];
    }
}
