package src.main.dsa.algorithms.data_structures.heap.max_heap;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Test {


    class Result {
        public static int findMinWeight(List<Integer> weights, int d) {
            // Write your code here
            int res = 0;
            Comparator<Integer> comparator = (a, b) -> b - a;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator);

            for (Integer integer : weights) {
                maxHeap.add(integer);
            }

            for (int i = 0; i < d; i++) {
                int maxWeight = maxHeap.poll();
                int remainingWeigth = maxWeight - maxWeight / 2;
                maxHeap.add(remainingWeigth);
            }

            while (!maxHeap.isEmpty()) {
                res += maxHeap.poll();
            }

            return res;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {

        }
    }

}
