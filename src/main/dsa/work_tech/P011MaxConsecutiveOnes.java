package src.main.dsa.work_tech;

public class P011MaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(getMaxConsecutiveOnes(new int[]{1, 1, 3, 2, 3, 1, 1, 1}));
    }

    static int getMaxConsecutiveOnes(int[] a) {
        // add your logic here
        int result = 0;
        int localCount = 0;
        for (int element : a) {
            if (element == 1) {
                localCount++;
                result = Math.max(localCount, result);
            } else {
                localCount = 0;
            }
        }
        return result;
    }
}
