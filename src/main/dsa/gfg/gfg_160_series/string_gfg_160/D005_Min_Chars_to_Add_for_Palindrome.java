package src.main.dsa.gfg.gfg_160_series.string_gfg_160;

public class D005_Min_Chars_to_Add_for_Palindrome {
    public static void main(String[] args) {
        System.out.println(minChar("abc"));
        System.out.println(minChar("aacecaaaa"));
        System.out.println(minChar("fxtlsgypsfa"));
    }
//    public static int minChar(String s) {
//        // Write your code here
//        int len = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int l = 0, r = i;
//            while (r < s.length() && s.charAt(l)==s.charAt(r)) {
//                len = Math.max(r-l+1, len);
//                r++;
//            }
//            r = i+1;
//            while (r < s.length() && s.charAt(l)==s.charAt(r)) {
//                len = Math.max(r-l+1, len);
//                r++;
//            }
//        }
//        return s.length() - len;
//    }

//    public static int minChar(String s) {
//        int res = 0;
//        int left = 0;
//        int right = s.length()-1;
//        while (left <= right && left < s.length() && right >= 0) {
//            while (s.charAt(left) != s.charAt(right) && right >= 0) {
//                right--;
//                res++;
//            }
//            left++;
//            right--;
//        }
//        return res;
//    }

    public static int minChar(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                res++;
            if (i > 0 && i < s.length() - 1 && s.charAt(i) == s.charAt(i - 1) && s.charAt(s.length() - 1 - i) == s.length() - i)
                res--;
        }
        return res;
    }
}
