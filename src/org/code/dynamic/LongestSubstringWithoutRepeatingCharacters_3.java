package org.code.dynamic;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        String aa = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters_3().lengthOfLongestSubstring(aa));
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        String[] strArr = new String[len];
        strArr[0] = chars[0] + "";
        for (int i = 1; i < len; i++) {
            if (strArr[i - 1].contains(chars[i] + "")) {
                strArr[i] = strArr[i - 1].substring(strArr[i - 1].indexOf(chars[i] + "") + 1) + chars[i] + "";
            } else {
                strArr[i] = strArr[i - 1] + chars[i];
            }
        }
        int maxLen = 0;
        for (String tmp : strArr) {
            if (tmp.length() > maxLen) {
                maxLen = tmp.length();
            }
        }
        return maxLen;
    }
}
