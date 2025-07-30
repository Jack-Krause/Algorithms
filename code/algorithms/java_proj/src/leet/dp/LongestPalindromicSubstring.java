package leet.dp;

import java.sql.SQLOutput;
import java.util.Arrays;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        longestPalindrome("babad");

    }

    public static void longestPalindrome(String s) {
        int[] ans = {0, 0};
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // all 1-length substrings are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // populate palindromes of substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                ans[0] = i;
                ans[1] = i + 1;
            }
        }

        for (int L = 3; L <= n; L++) {
            System.out.printf("Window = %d\n", L);
            for (int start = 0; start <= n - L; start++) {
                int end = start + L - 1;
                System.out.printf("\s\s start = %d, end = %d\n", start, end);

                // short-circuit if sub-string isn't a palindrome
                boolean sub_is_palindrome = dp[start + 1][end - 1];
                if (sub_is_palindrome && (s.charAt(start) == s.charAt(end))) {
                    dp[start][end] = true;
                    ans[0] = start;
                    ans[1] = end;
                } else {
                    dp[start][end] = false;
                }
            }
        }

        for (boolean[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(Arrays.toString(ans));
        System.out.println(s.substring(ans[0], ans[1] + 1));
    }

}
