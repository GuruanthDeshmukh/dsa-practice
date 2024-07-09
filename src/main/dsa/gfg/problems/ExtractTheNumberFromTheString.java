package src.main.dsa.gfg.problems;

import java.util.Arrays;

public class ExtractTheNumberFromTheString {

    public static void main(String[] args) {
        System.out.println(ExtractNumber("zg 9 e 12 b 16 10 8 10 l 7"));
    }

    public static long ExtractNumber(String sentence) {
        String[] arr = sentence.split(" ");
        boolean contains9 = false;
        long x = Long.MIN_VALUE;
        for (String s : arr) {
            if (s.contains("9")) {
                contains9 = true;
            }
            if (!contains9) try {
                {
                    x = Long.max(x, Long.parseLong(s));
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            contains9 = false;
        }
        return x;
    }
}
