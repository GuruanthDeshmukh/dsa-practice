package src.main.dsa.neetcode.two_fifty.two_pointer;

public class Valid_Palindrome_II {
    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abc"));
        System.out.println(validPalindrome("eceec"));
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] ch = s.toCharArray();
        boolean valid = true;
        return checkPalindrome(start, end, ch, valid);
    }

    private static boolean checkPalindrome(int start, int end, char[] ch, boolean valid) {
        while (start < end) {
            if (ch[start] == ch[end]) {
                start++;
                end--;
                continue;
            }
            if (valid) {
                return checkPalindrome(start + 1, end, ch, false) || checkPalindrome(start, end - 1, ch, false);
            } else {
                return false;
            }
        }
        return true;
    }

}
