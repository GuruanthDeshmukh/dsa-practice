package src.main.dsa.neetcode.two_fifty.two_pointer;

import java.util.Arrays;

public class Reverse_String {

    public static void main(String[] args) {
        char[] ch = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] ch1 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(ch);
        reverseString(ch1);
        System.out.println(Arrays.toString(ch));
        System.out.println(Arrays.toString(ch1));
    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < (s.length / 2); i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

}
