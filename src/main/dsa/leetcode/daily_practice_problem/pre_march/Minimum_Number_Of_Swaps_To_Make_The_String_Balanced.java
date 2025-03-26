package src.main.dsa.leetcode.daily_practice_problem.pre_march;

/*
You are given a 0-indexed string s of even length n. The string consists of exactly
n / 2 opening brackets '[' and n / 2 closing brackets ']'.

A string is called balanced if and only if:

It is the empty string, or
It can be written as AB, where both A and B are balanced strings, or
It can be written as [C], where C is a balanced string.
You may swap the brackets at any two indices any number of times.

Return the minimum number of swaps to make s balanced.



Example 1:

Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".
Example 2:

Input: s = "]]][[["  []
Output: 2
Explanation: You can do the following to make the string balanced:
- Swap index 0 with index 4. s = "[]][][".
- Swap index 1 with index 5. s = "[[][]]".
The resulting string is "[[][]]".
Example 3:

Input: s = "[]"
Output: 0
Explanation: The string is already balanced.


Constraints:

n == s.length
2 <= n <= 106
n is even.
s[i] is either '[' or ']'.
The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2.
 */
public class Minimum_Number_Of_Swaps_To_Make_The_String_Balanced {
    public static void main(String[] args) {
        System.out.println(minSwaps("]]][[["));
    }

    public static int minSwaps(String s) {
        char[] sToArray = s.toCharArray();
        int swaps = 0;
        int start = 0;
        int end = s.length() - 1;
        int frontBalance = 0;
        int endBalance = 0;
        while (start < end) {
            if (sToArray[start] == '[') {
                start++;
                frontBalance++;
                continue;
            } else if (sToArray[start] == ']') {
                end--;
                endBalance--;
                continue;
            } else if ((sToArray[start] != '[') && (sToArray[start] != ']')) {
                if (frontBalance == 0 && endBalance == 0) {
                    swap(sToArray, start, end);
                    frontBalance++;
                    endBalance++;
                    swaps++;
                } else {
                    frontBalance--;
                    endBalance--;
                }
            }
        }
        return swaps;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
