package src.main.dsa.leetcode.daily_practice_problem.march;

public class Check_if_Number_is_a_Sum_of_Powers_of_Three {

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12));
        System.out.println(checkPowersOfThree(91));
        System.out.println(checkPowersOfThreeV2(91));
        System.out.println(checkPowersOfThree(21));
        System.out.println(checkPowersOfThree(6378022));
    }

    public static boolean checkPowersOfThree(int n) {
        double k = Math.floor(Math.pow(n, (double) 1 / 3));
        double sum = 0;
        for (double i = k; i >= 0; i--) {
            sum += Math.pow(3, i);
            if (sum == n)
                return true;
            if (sum > n)
                sum -= Math.pow(3, i);
        }

        return false;
    }

    public static boolean checkPowersOfThreeV2(int n) {
        if (n == 1) {
            return true;
        }

        if (n % 3 == 0) {
            return checkPowersOfThreeV2(n / 3);
        }

        if ((n - 1) % 3 == 0) {
            return checkPowersOfThreeV2((n - 1) / 3);
        }

        return false;
    }
}
