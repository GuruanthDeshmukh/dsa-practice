package src.main.dsa.gfg.gfg_160_series.arrays_gfg_160;

import java.util.Arrays;

public class D002_Move_All_Zeroes_to_End {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println(Arrays.toString(a1));
        pushZerosToEnd(a1);
        System.out.println(Arrays.toString(a1));
        int[] a2 = new int[]{10, 20, 30};
        System.out.println(Arrays.toString(a2));
        pushZerosToEnd(a2);
        System.out.println(Arrays.toString(a2));
        int[] a3 = new int[]{0, 0};
        System.out.println(Arrays.toString(a3));
        pushZerosToEnd(a3);
        System.out.println(Arrays.toString(a3));

    }

    public static void pushZerosToEnd(int[] arr) {
        // code here
        int zero_index = -1;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 0 && zero_index == -1) {
//                zero_index = i;
//            } else if (arr[i] != 0 && zero_index != -1){
//                arr[zero_index] = arr[i];
//                arr[i] = 0;
//                zero_index++;
//            }

            // 1, 2, 0, 4, 3, 0, 5, 0
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
    }
}
