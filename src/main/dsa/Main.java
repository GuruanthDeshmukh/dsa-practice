package src.main.dsa;

import java.util.*;

public class Main {
    public void m1(Object o) {
        System.out.println("Object Method");
    }

//    public void m1(String s) {
//        System.out.println("String Method");
//    }

    public void m1(Integer i) {
        System.out.println("Integer Method");
    }

    public static void main(String[] args) {
//        printSubsequences(new int[]{1,2,3,4,5}, 0, new ArrayList<>());
//        System.out.println(exclusiveTime(3, List.of(new String[]{"0:start:0","2:start:4","2:end:5","1:start:7","1:end:10","0:end:11"})));
//        System.out.println(canRearrangeToMatch("0011",List.of(new String[]{"0?10","0011","????"})));
//        System.out.println(canRearrangeToMatch("101011",List.of(new String[]{"???111","001101"})));
//        System.out.println(isPalindrome(121));
//        String x = "Greatest/ n]]am\\e e[*ver :in e?xis[/tance".replaceAll("[/\\\\?*\\[\\]:]", "#");
//        System.out.println(x);
//        new Main().m1(null);

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int count = 0;

        while (a < c && b < c) {
            if (a < b) {
                a = a + b;
                count++;
            } else {
                b = b + a;
                count++;
            }
        }
        while (a < c) {
            a = b + a;
            count++;
        }
        while (b < c) {
            b = b + a;
            count++;
        }
        System.out.println(count);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int rev = 0;
        int val = x;
        while (x > 0) {
            int temp = x % 10;
            rev = 10 * rev + temp;
            x /= 10;
        }
        return val == rev;
    }

    public static List<Integer> exclusiveTime(int n, List<String> logs) {
        // Initialize an array to store the exclusive time of each function
        int[] exclusiveTimes = new int[n];
        // Stack to keep track of the function call hierarchy
        Stack<Integer> stack = new Stack<>();
        // Variable to track the last processed timestamp
        int previousTime = 0;

        for (String log : logs) {
            // Parse each log entry
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            // If there's an active function, accumulate the time spent since the last log entry
            if (!stack.isEmpty()) {
                exclusiveTimes[stack.peek()] += timestamp - previousTime;
            }
            // Update previous time to current timestamp
            previousTime = timestamp;

            if (type.equals("start")) {
                // When a function starts, push it onto the stack
                stack.push(functionId);
            } else {
                // When a function ends, pop it from the stack and add 1 to include the end timestamp
                exclusiveTimes[stack.pop()] += 1;
                previousTime += 1; // Move past the end timestamp for the next function
            }
        }

        // Convert the result array to a list for the output format
        List<Integer> result = new ArrayList<>();
        for (int time : exclusiveTimes) {
            result.add(time);
        }

        return result;
    }

    public static List<Integer> exclusiveTimeV2(int n, List<String> logs) {
        int[] exclusiveTimes = new int[n];
        Stack<Integer> stack = new Stack<>();
        int previousTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);
            if (!stack.isEmpty()) {
                exclusiveTimes[stack.peek()] += timestamp - previousTime;
            }
            previousTime = timestamp;
            if (type.equals("start")) {
                stack.push(functionId);
            } else {
                exclusiveTimes[stack.pop()] += 1;
                previousTime += 1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int time : exclusiveTimes) {
            result.add(time);
        }
        return result;
    }


    public static List<String> canRearrangeToMatch(String binary, List<String> arr) {
        // Step 1: Sort the binary string and calculate target counts of '0's and '1's
        char[] sortedBinaryArray = binary.toCharArray();
        Arrays.sort(sortedBinaryArray);
        String sortedBinary = new String(sortedBinaryArray);

        int targetZeroCount = 0;
        int targetOneCount = 0;
        for (char c : sortedBinary.toCharArray()) {
            if (c == '0') targetZeroCount++;
            else targetOneCount++;
        }

        List<String> result = new ArrayList<>();

        // Step 2: Process each string in arr
        for (String s : arr) {
            int zeroCount = 0;
            int oneCount = 0;
            int questionMarkCount = 0;

            // Count '0's, '1's, and '?'s in the current string
            for (char c : s.toCharArray()) {
                if (c == '0') zeroCount++;
                else if (c == '1') oneCount++;
                else questionMarkCount++;
            }

            // Calculate the needed zeros and ones
            int requiredZeros = targetZeroCount - zeroCount;
            int requiredOnes = targetOneCount - oneCount;

            // Check if '?' characters can match exactly the needed counts
            if (requiredZeros >= 0 && requiredOnes >= 0 && (requiredZeros + requiredOnes == questionMarkCount)) {
                result.add("YES");
            } else {
                result.add("NO");
            }
        }

        return result;
    }


//    public static void main(String[] args) {
////        System.out.println(Arrays.toString(intersectV2(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
////        System.out.println(minDifference(new int[]{1,5,0,10,14}));
////        System.out.println(reverseParenthesesV2("(u(love)i)"));
////        System.out.println(numTeams(new int[]{2,5,3,4,1}));
////        System.out.println(minExtraCharV1("dwmodizxvvbosxxw",
////                new String[]{"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"}));
////        System.out.println(rob(new int[] {2,7,9,3,1}));
////        System.out.println(Arrays.toString(arrayRankTransform(new int[]{100,100,100})));
//
//
//        Integer a = 1;
//        Integer b = 1;
//        System.out.println(a==b);
//        Integer e = 300;
//        Integer f = 300;
//        System.out.println(e==f);
//        String x = "abcd";
//        String l = "pqrs";
//        Integer y = 10;
//        if (l.equals("xyz") && amethod(x)) {
//            System.out.println("&&");
//        }
//
//        if (l.equals("xyz") & amethod(x)) {
//            System.out.println("&");
//        }
//
//        System.out.println(y&5);
//    }

    //    public static void printSubsequences(int[] arr, int index,
//                                               ArrayList<Integer> path) {
//        {
//            if (index == arr.length)
//            {
//                if (path.size() > 0)
//                    System.out.println(path);
//            }
//            else
//            {
//                printSubsequences(arr, index + 1, path);
//                path.add(arr[index]);
//                printSubsequences(arr, index + 1, path);
//                path.remove(path.size() - 1);
//            }
//            return;
//        }
//    }
    static boolean amethod(String x) {
        System.out.println("a method execution");
        return x.equalsIgnoreCase("abcd");
    }

    public static int[] arrayRankTransform(int[] arr) {
        int[] resp = new int[arr.length];
        int[] temp = Arrays.copyOf(arr, arr.length);
        int rank = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(temp);
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], rank);
                rank++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            resp[i] = map.get(arr[i]) + 1;
        }
        return resp;
    }

    public static int rob(int[] nums) {
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                evenSum += nums[i];
            else
                oddSum += nums[i];
        }
        return Math.max(oddSum, evenSum);
    }

    public static int minExtraCharV1(String s, String[] dictionary) {
        StringBuilder sb = new StringBuilder(s);
        for (String element : dictionary) {
            if (s.contains(element)) {
                int size = sb.indexOf(element);
                String head = sb.substring(0, Math.max(size, 0));
                String tail = sb.substring(size + element.length(), sb.length());
                sb = new StringBuilder(head.concat(tail));
            }
        }
        return sb.length();
    }

    // need to complete
    public static int minExtraCharV2(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
        for (int i = 0; i < s.length(); i++) {

        }
        return 0;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < n) {
            while (j < m) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    i++;
                }
                j++;
            }
            i++;
        }

        int[] resp = new int[list.size()];
        for (int k = 0; k < list.size(); k++) resp[k] = list.get(k);

        return resp;
    }

    public static int[] intersectV2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] resp = new int[list.size()];
        for (int k = 0; k < list.size(); k++) resp[k] = list.get(k);

        return resp;
    }

    public static int minDifference(int[] nums) {
        if (nums.length < 5)
            return 0;
        return minDifference(nums, 3);
    }

    public static int minDifference(int[] nums, int k) {
        if (nums.length < 5 && k > nums.length)
            return 0;

        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;

        int i = 0;
        while (i <= k) {
            res = Math.min(res, nums[nums.length - 1 - i] - nums[k - i]);
            i++;
        }

        return res;
    }

    public static String reverseParentheses(String s) {
        Stack<String> stk = new Stack<>();
        String res = "";
        int index = 0;

        while (index < s.length()) {
            if (!")".equals(String.valueOf(s.charAt(index)))) {
                stk.add(String.valueOf(s.charAt(index)));
            } else {
                if (!stk.isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (!"(".equals(stk.peek())) {
                        stringBuilder.append(stk.pop());
                    }
                    stk.pop();
                    int i = 0;
                    while (i < stringBuilder.length()) {
                        stk.add(String.valueOf(stringBuilder.charAt(i)));
                        i++;
                    }
                }
            }
            index++;
        }
        StringBuilder stringBuilderTemp = new StringBuilder();
        while (!stk.isEmpty()) {
            stringBuilderTemp.append(stk.pop());
        }
        res = stringBuilderTemp.reverse().toString();
        return res;
    }

    public static String reverseParenthesesV2(String s) {
        Stack<String> stk = new Stack<>();
        String res = "";
        int index = 0;

        while (index < s.length()) {
            if (!")".equals(String.valueOf(s.charAt(index)))) {
                stk.add(String.valueOf(s.charAt(index)));
            } else {
                if (!stk.isEmpty()) {
                    String stringBuilder = "";
                    while (!"(".equals(stk.peek())) {
                        stringBuilder = stringBuilder.concat(stk.pop());
                    }
                    stk.pop();
                    int i = 0;
                    while (i < stringBuilder.length()) {
                        stk.add(String.valueOf(stringBuilder.charAt(i)));
                        i++;
                    }
                }
            }
            index++;
        }
        StringBuilder stringBuilderTemp = new StringBuilder();
        while (!stk.isEmpty()) {
            stringBuilderTemp.append(stk.pop());
        }
        res = stringBuilderTemp.reverse().toString();
        return res;
    }

//    public static int numTeams(int[] rating) {
//        int count = 0;
//        for (int i = 0; i < rating.length - 3; i++) {
//            if (rating[i] < rating[i+1] < rating[i+2])
//        }
//    }
}
