package src.main.dsa.neetcode.two_fifty.sliding_window;

import java.util.Arrays;

public class Permutation_in_String {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusionV3("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusionV3("ab", "eidboaoo"));
        System.out.println(checkInclusion("adc", "dcda"));
        System.out.println(checkInclusionV3("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] freq = new int[26];
        for (char a : s1.toCharArray()) {
            freq[a - 'a']++;
        }
        int start = 0;
        while (start < s2.length()) {
            if (freq[s2.charAt(start) - 'a'] <= 0) {
                start++;
            } else {
                int[] temp = Arrays.copyOf(freq, freq.length);
                int tempStart = 0;
                int falseStart = start;
                while (falseStart < s2.length() && tempStart < s1.length()) {
                    temp[s2.charAt(falseStart) - 'a']--;
                    if (temp[s2.charAt(falseStart) - 'a'] < 0)
                        break;
                    falseStart++;
                    tempStart++;
                }
                boolean res = true;
                for (int i : temp) {
                    if (i != 0) {
                        res = false;
                        start++;
                        break;
                    }
                }
                if (res)
                    return true;
            }
        }
        return false;
    }

    private static boolean isValid(int[] temp) {
        for (int i : temp) {
            if (i != 0)
                return false;
        }
        return true;
    }

    public static boolean checkInclusionV2(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }

    public static boolean checkInclusionV3(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (Arrays.equals(s1Count, s2Count))
                return true;
            int index = s2.charAt(l) - 'a';
            l++;
            s2Count[index]--;
            index = s2.charAt(r) - 'a';
            s2Count[index]++;
        }

        return Arrays.equals(s1Count, s2Count);
    }
}
