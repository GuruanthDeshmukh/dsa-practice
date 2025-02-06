package src.main.dsa.work_tech;

import java.util.ArrayList;
import java.util.List;

public class P002PositiveCumulativeSum {

    public static void main(String[] args) {
        System.out.println(getPositiveCumulativeSum(new int[]{1, -2, 3, 4, -6}));
    }

    static List<Integer> getPositiveCumulativeSum(int[] arr) {
        // add your logic here
        List<Integer> res = new ArrayList<>();
        if (arr[0] > 0)
            res.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
            if (arr[i] > 0)
                res.add(arr[i]);
        }
        return res;
    }
}
