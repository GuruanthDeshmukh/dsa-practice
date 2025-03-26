package src.main.dsa.neetcode.two_fifty.two_pointer;

import java.util.Stack;

public class Trapping_Rain_Water {

    public static void main(String[] args) {

    }

    public static int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= max) {
                max = height[i];
                index = i;
            }
        }
        stack.push(max);
        while (!stack.isEmpty()) {

        }
        return res;
    }

}
