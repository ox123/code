package org.code.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        String aa = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters_3().lengthOfLongestSubstring(aa));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters_3().lengthOfLongestSubstring2(aa));
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

    /**
     * TODO 理解 使用滑动窗口
     * https://juejin.im/post/5d65f29d518825637965fb43#heading-7
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int[] freq = new int[256];
        int l = 0, r = -1;
        int res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    /**
     * TODO https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/471513/Efficient-Java-Solution-in-O(n)-time-and-O(1)-Space-with-clear-explanation
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int max = 0;
        int leftPointer = 0;

        int[] characters = new int[256];

        for (int i = 0; i < s.length(); i++){
            int currentChar = (int) s.charAt(i);
            if (characters[currentChar] != 0)
                leftPointer = Math.max(characters[currentChar], leftPointer);
            max = Math.max(max, i-leftPointer+1);
            characters[currentChar] = i+1;
        }
        return max;
    }

    /**
     * TODO 深入理解思路，时间复杂度和空间复杂度都是o(n)
     * 使用滑动窗口保存当前的值，并不停的更新res
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
        int res = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char item = s.charAt(i);
            if (map.containsKey(item)) {
                j = Math.max(j, map.get(item) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
