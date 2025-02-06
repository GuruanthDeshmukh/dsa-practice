package src.main.dsa.leetcode.daily_practice_problem;

public class Minimum_Number_of_Changes_to_Make_Binary_String_Beautiful {

    public static void main(String[] args) {
        System.out.println(minChanges("1001"));
        System.out.println(minChanges("10"));
        System.out.println(minChanges("0000"));
    }

    public static int minChanges(String s) {
        int sol = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i % 2 != 0 && s.charAt(i) != s.charAt(i - 1))
                sol++;
        }
        return sol;
    }
}
