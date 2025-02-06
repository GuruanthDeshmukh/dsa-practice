package src.main.dsa.work_tech;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class P003IdenticalTwins {

    public static void main(String[] args) {
        System.out.println(getIdenticalTwinsCountV2(new int[]{1, 2, 2, 3, 2, 1}));
    }

    static int getIdenticalTwinsCountV1(int[] arr) {
        // add your logic here
        int identicalTwins = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] == arr[j])
                    identicalTwins++;
            }
        }

//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=0; i<arr.length; i++) {
//            if(map.containsKey(arr[i]))
//                map.put(arr[i],map.get(arr[i] + 1));
//            else
//                map.put(arr[i],1);
//        }
//
//        for(Map.Entry<Integer, Integer> x : map.entrySet()) {
//            identicalTwins = identicalTwins + (x.getValue() * (x.getValue()-1));
//        }
        return identicalTwins;
    }

    static int getIdenticalTwinsCountV2(int[] arr) {
        // add your logic here
        AtomicInteger identicalTwins = new AtomicInteger();
        int[] x = {0};

        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(element -> {
            map.put(element, map.getOrDefault(element, 0) + 1);
        });

        map.keySet().forEach(key -> {
            if (map.get(key) > 1) {
                x[0] += factorial(map.get(key)) / (factorial((map.get(key) - 2)) * 2);
//              x[0] += (map.get(key) * (map.get(key)-1)) / 2;
            }
        });

        return x[0];
    }

    private static int factorial(Integer x) {
        if (x == 1 || x == 0)
            return 1;
        if (x < 0)
            throw new RuntimeException("Invalid argument");
        return x * factorial(x - 1);
    }

}


// 1 : 0
// 2 : 1
// 3 : 3
// 4 : 6


// n! / ((n-r)!*r!)