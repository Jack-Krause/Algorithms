package leet.dp;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

    }

    public static void longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // all 1-length substrings are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }



    }

}
