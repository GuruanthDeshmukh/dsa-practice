package src.main.dsa.leetcode.daily_practice_problem;

import java.util.Stack;

/*
You are given a string s consisting only of uppercase English letters.

You can apply some operations to this string where, in one operation, you can remove any
occurrence of one of the substrings "AB" or "CD" from s.

Return the minimum possible length of the resulting string that you can obtain.

Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.



Example 1:

Input: s = "ABFCACDB"
Output: 2
Explanation: We can do the following operations:
- Remove the substring "ABFCACDB", so s = "FCACDB".
- Remove the substring "FCACDB", so s = "FCAB".
- Remove the substring "FCAB", so s = "FC".
So the resulting length of the string is 2.
It can be shown that it is the minimum length that we can obtain.
Example 2:

Input: s = "ACBBD"
Output: 5
Explanation: We cannot do any operations on the string so the length remains the same.


Constraints:

1 <= s.length <= 100
s consists only of uppercase English letters.
 */
public class Minimum_String_Length_After_Removing_Substrings {
    public static void main(String[] args) {
        System.out.println(minLengthV2("ACBBD"));
    }

    public static int minLength(String s) {
        int res = 0;
        if (s.isEmpty())
            return 0;
        boolean recurrsionNeeded = false;
        String[] arrayWithoutAb = s.split("AB");
        if (arrayWithoutAb.length == 0)
            return 0;
        StringBuilder sb = new StringBuilder(arrayWithoutAb[0]);
        if (arrayWithoutAb.length > 1) {
            recurrsionNeeded = true;
            for (int i = 1; i < arrayWithoutAb.length; i++) {
                sb.append(arrayWithoutAb[i]);
            }
        }
        String sWithoutAb = sb.toString();
        String[] arrayWithoutCd = sWithoutAb.split("CD");
        if (arrayWithoutCd.length == 0)
            return 0;
        sb = new StringBuilder(arrayWithoutCd[0]);
        if (arrayWithoutCd.length > 1) {
            recurrsionNeeded = true;
            for (int i = 1; i < arrayWithoutCd.length; i++) {
                sb.append(arrayWithoutCd[i]);
            }
        }
        String sWithoutCd = sb.toString();
        if (recurrsionNeeded)
            return res + minLength(sWithoutCd);
        return sWithoutCd.length();
    }

    public static int minLengthV2(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(String.valueOf(s.charAt(i)));
                continue;
            }
            if (stack.peek().equalsIgnoreCase("A") || stack.peek().equalsIgnoreCase("C")) {
                if (stack.peek().equalsIgnoreCase("A") && s.charAt(i) == 'B') {
                    stack.pop();
                    continue;
                }
                if (stack.peek().equalsIgnoreCase("C") && s.charAt(i) == 'D') {
                    stack.pop();
                    continue;
                }
            }
            stack.add(String.valueOf(s.charAt(i)));
        }
        return stack.size();
    }
}
