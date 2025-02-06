package src.main.dsa.gfg.gfg_160_series.string_gfg_160;

import java.util.Stack;

public class D002_Add_Binary_Strings {

    public static void main(String[] args) {
        System.out.println(addBinary("1101", "111"));
    }

    public static String addBinary(String s1, String s2) {
        // code here
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i1 = s1.length() - 1, i2 = s2.length() - 1;
        boolean oneCarryOverFlag = false;
        while (i1 >= 0 && i2 >= 0) {
            if (oneCarryOverFlag)
                stack.push((char) (s1.charAt(i1) ^ s2.charAt(i2) ^ '1'));
            else
                stack.push((char) (s1.charAt(i1) ^ s2.charAt(i2)));
            oneCarryOverFlag = s1.charAt(i1) == '1' && s2.charAt(i2) == '1';
            i1--;
            i2--;
        }
        while (i1 >= 0) {
            stack.push(s1.charAt(i1));
            i1--;
        }
        while (i2 >= 0) {
            stack.push(s2.charAt(i2));
            i2--;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
