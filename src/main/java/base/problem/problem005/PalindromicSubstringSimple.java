package base.problem.problem005;

import base.Algorithm;

public class PalindromicSubstringSimple implements Algorithm<String, String> {

    @Override
    public String performAlgorithm(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j+ 1);
                if (isPalindrome(sub)) {
                    if (sub.length() > longest.length()) {
                        longest = sub;
                    }
                }
            }
        }
        return longest;
    }

    private boolean isPalindrome(String s) {
        char[] ary = s.toCharArray();
        for (int i = 0; i < ary.length / 2; i++) {
            if (ary[i] != ary[ary.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

}
