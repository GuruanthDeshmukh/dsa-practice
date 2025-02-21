package src.main.dsa.neetcode.two_fifty.arrays_and_hashing;

public class Valid_Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int startPointer = 0;
        int endPointer = s.length() - 1;
        while (startPointer < endPointer) {
            if (Character.isLetterOrDigit(s.charAt(startPointer)))
                if (s.charAt(startPointer) < 48 || (s.charAt(startPointer) > 57 && s.charAt(startPointer) < 97) || s.charAt(startPointer) > 122) {
                    startPointer++;
                    continue;
                }
            if (s.charAt(endPointer) < 48 || (s.charAt(endPointer) > 57 && s.charAt(endPointer) < 97) || s.charAt(endPointer) > 122) {
                endPointer--;
                continue;
            }
            if (s.charAt(startPointer) != s.charAt(endPointer))
                return false;

            startPointer++;
            endPointer--;
        }
        return true;
    }
}
