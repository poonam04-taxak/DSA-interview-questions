
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 1) return "";

        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i);       // odd length
            int len2 = expandAroundCenter(s, i, i + 1);   // even length
            int len = Math.max(len1, len2);

            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + result);

        // Additional test cases:
        System.out.println("Test 1: " + longestPalindrome("cbbd"));      // Expected: "bb"
        System.out.println("Test 2: " + longestPalindrome("a"));         // Expected: "a"
        System.out.println("Test 3: " + longestPalindrome("ac"));        // Expected: "a" or "c"
        System.out.println("Test 4: " + longestPalindrome("forgeeksskeegfor")); // Expected: "geeksskeeg"
    }
}
