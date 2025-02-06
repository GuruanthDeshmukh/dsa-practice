package src.main.dsa.work_tech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P004EvenNumberOfDigits {

    public static void main(String[] args) {
        System.out.println(getEvenDigitNumbers(new int[]{42, 564, 5775, 34, 123, 454, 1, 5, 45, 3556, 23442}));
    }

    static List<Integer> getEvenDigitNumbers(int[] arr) {
        // add your logic here
        List<Integer> response = new ArrayList<>();
        Arrays.stream(arr).sequential().forEach(element -> {
            if (isEvenDigitCount(element))
                response.add(element);
        });

        return response;
    }

    private static boolean isEvenDigitCount(int element) {
        int count = 1;
        while (element > 10) {
            count++;
            element /= 10;
        }
        return count % 2 == 0;
    }

}
