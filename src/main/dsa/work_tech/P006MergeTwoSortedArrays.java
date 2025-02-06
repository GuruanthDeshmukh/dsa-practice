package src.main.dsa.work_tech;

import java.util.Arrays;

public class P006MergeTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{1, 2, 3, 4, 4}, new int[]{2, 4, 5, 5})));
        // 1, 2, 2, 3, 4, 4, 4, 5, 5
    }

    static int[] mergeSortedArrays(int[] a, int[] b) {
        // add your logic here
        int[] resp = new int[a.length + b.length];
        int aPointer, bPointer;
        aPointer = bPointer = 0;
        for (int i = 0; i < a.length + b.length; i++) {
            if (bPointer >= b.length && aPointer < a.length) {
                resp[i] = a[aPointer];
                aPointer++;
            }
            if (aPointer >= a.length && bPointer < b.length) {
                resp[i] = b[bPointer];
                bPointer++;
            }
            if (aPointer < a.length && bPointer < b.length) {
                if (a[aPointer] < b[bPointer]) {
                    resp[i] = a[aPointer];
                    aPointer++;
                } else {
                    resp[i] = b[bPointer];
                    bPointer++;
                }
            }
        }
        return resp;
    }

}
