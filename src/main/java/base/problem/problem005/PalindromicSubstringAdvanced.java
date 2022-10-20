package base.problem.problem005;

import base.Algorithm;

public class PalindromicSubstringAdvanced implements Algorithm<String, String> {

    @Override
    public String performAlgorithm(String s) {
        char[] ary = s.toCharArray();
        int n = ary.length;
        boolean[][] dp = new boolean[n][n];
        String longest = "";
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            longest = ary[i] + "";
        }
        for (int i = 0; i < dp.length - 1; i++) {
            if (ary[i] == ary[i+1]) {
                dp[i][i+1] = true;
                if (longest.length() == 1) {
                    longest = s.substring(i, i+2);
                }
            }
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < dp.length - i; j++) {
                if (dp[j+1][j+i-1] && ary[j] == ary[j+i]) {
                    dp[j][j+i] = true;
                    if ((i + 1) > longest.length()) {
                        longest = s.substring(j, j+i+1);
                    }
                }
            }
        }
        return longest;
    }

}
