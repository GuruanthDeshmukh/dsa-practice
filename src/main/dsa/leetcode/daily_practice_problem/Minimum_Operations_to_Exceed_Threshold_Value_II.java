package src.main.dsa.leetcode.daily_practice_problem;

import java.util.PriorityQueue;

public class Minimum_Operations_to_Exceed_Threshold_Value_II {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 11, 10, 1, 3}, 7));
        System.out.println(minOperations(new int[]{1, 1, 2, 4, 9}, 20));
    }

    public static int minOperations(int[] nums, int k) {
        int count = 0;
        PriorityQueue<Long> minHeap
                = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        for (int num : nums) {
            minHeap.offer((long) num);
        }
        while (minHeap.peek() < k) {
            long x = minHeap.poll();
            if (!(minHeap.peek() < k))
                break;
            long y = minHeap.poll();
            minHeap.add(Math.min(x, y) * 2 + Math.max(x, y));
            count++;
        }
        return count;
    }
}
