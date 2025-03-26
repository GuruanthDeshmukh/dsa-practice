package src.main.dsa.neetcode.two_fifty.two_pointer;

public class Container_With_Most_Water {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] heights) {
        int res = 0;
        int start = 0, end = heights.length - 1;
        while (start < end) {
            res = Math.max(Math.min(heights[start], heights[end]) * (end - start), res);
            if (heights[start] < heights[end])
                start++;
            else
                end--;
        }
        return res;
    }
}
