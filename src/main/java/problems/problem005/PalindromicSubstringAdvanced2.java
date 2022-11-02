package problems.problem005;

import base.algorithm.Algorithm;

public class PalindromicSubstringAdvanced2 implements Algorithm<String, String> {

    @Override
    public String performAlgorithm(String s) {
        int n = s.length();
        char[] ary = s.toCharArray();
        String longest = "";
        for (int i = 0; i < n; i++) {
            int k = 1;
            while (i - k >= 0 && i + k < n) {
                if (ary[i-k] != ary[i+k]) {
                    break;
                }
                k++;
            }
            if (2 * k - 1 > longest.length()) {
                longest = s.substring(i - k + 1, i + k);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (ary[i] == ary[i+1]) {
                int k = 1;
                while (i - k >= 0 && i + k + 1 < n) {
                    if (ary[i-k] != ary[i+1+k]) {
                        break;
                    }
                    k++;
                }
                if (2 * k > longest.length()) {
                    longest = s.substring(i - k + 1, i + k + 1);
                }
            }
        }
        return longest;
    }

    @Override
    public String getVariantName() {
        return "Expand around center";
    }

}
