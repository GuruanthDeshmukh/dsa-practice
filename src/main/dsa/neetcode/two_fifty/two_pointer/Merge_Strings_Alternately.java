package src.main.dsa.neetcode.two_fifty.two_pointer;

public class Merge_Strings_Alternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr")); //apbqcr
        System.out.println(mergeAlternately("ab", "pqrs")); //apbqrs
        System.out.println(mergeAlternately("abcd", "pq")); //apbqcd
    }

    public static String mergeAlternately(String word1, String word2) {
        int iterations = Math.min(word1.length(), word2.length());
        int currentPosition = 0;
        StringBuilder sb = new StringBuilder();
        while (currentPosition < iterations) {
            sb.append(word1.charAt(currentPosition)).append(word2.charAt(currentPosition));
            currentPosition++;
        }
        if (word1.length() > word2.length()) {
            while (currentPosition < word1.length()) {
                sb.append(word1.charAt(currentPosition));
                currentPosition++;
            }
        } else if (word2.length() > word1.length()) {
            while (currentPosition < word2.length()) {
                sb.append(word2.charAt(currentPosition));
                currentPosition++;
            }
        }

        return sb.toString();
    }
}
