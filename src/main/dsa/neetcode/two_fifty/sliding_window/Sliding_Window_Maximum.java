package src.main.dsa.neetcode.two_fifty.sliding_window;

import java.util.*;

public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindowV2(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5)));
        System.out.println(Arrays.toString(maxSlidingWindowV2(new int[]{1, -1}, 1)));
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindowV2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindowV2(new int[]{1}, 1)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<List<Integer>> priorityQueue1 = new PriorityQueue<>((o1, o2) -> o2.get(0).compareTo(o1.get(0)));
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(i);
            priorityQueue1.add(list);
        }
        int index = 0;
        res[index] = priorityQueue.peek();
        for (int i = k; i < nums.length; i++) {
            priorityQueue.remove(nums[i - k]);
            index++;
            priorityQueue.add(nums[i]);
            res[index] = priorityQueue.peek();
        }
        return res;
    }

    public static int[] maxSlidingWindowV2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            int[] arr = new int[2];
            arr[0] = nums[i];
            arr[1] = i;
            priorityQueue.add(arr);
        }
        int index = 0;
        res[index] = priorityQueue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            while (priorityQueue.size() > 0 && priorityQueue.peek()[0] > nums[i] && i - priorityQueue.peek()[1] >= k)
                priorityQueue.poll();
            index++;
            int[] arr = new int[2];
            arr[0] = nums[i];
            arr[1] = i;
            priorityQueue.add(arr);
            res[index] = priorityQueue.peek()[0];
        }
        return res;
    }
}
