package leet.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountVowelStrings {

    private static void countVowelStringsVis(int n) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int n_vowels = 5;
        int[][] dp = new int[n + 1][n_vowels];

        for (int j = 0; j < n_vowels; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 4; j >= 0; j--) {
                dp[i][j] = dp[i - 1][j] + (j < 4 ? dp[i][j + 1] : 0);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.printf("Length i = %d\n", i);
            for (int j = 0; j < n_vowels; j++) {
                System.out.printf("  start with '%c': %d\n", vowels[j], dp[i][j]);
            }
            System.out.println();
        }

        int total = 0;
        for (int j = 0; j < 5; j++) {
            total += dp[n][j];
        }


        System.out.println("total = " + total);
    }



    private static int countVowelStrings(int n) {
        // dp[j] = numbe rof sorted strings of the current length ending in vowel j
        int[] dp = new int[5];
        Arrays.fill(dp, 1);

        for (int len = 2; len <= n; len++) {
            for (int i = 3; i >= 0; i--) {
                dp[i] += dp[i + 1];
            }
        }

        int total = 0;
        for (Integer i : dp) {
            total += i;
        }

        return total;
    }


    public static void main(String[] args) {
//        countVowelStringsVis(2);
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(2));
    }



}
