package org.code.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAnagrams_438 {
    public static void main(String[] args) {
        String s = "abab";
        String t = "ab";
        int length = s.length();
        for (int i = 0; i <= length - t.length(); i++) {
            System.out.println(s.substring(i,i+2));
        }
        System.out.println(s.substring(2,t.length()));
        System.out.println(new FindAnagrams_438().findAnagrams(s, t));
    }

    /**
     *Runtime: 1992 ms, faster than 5.01% of Java online submissions for Find All Anagrams in a String.
     * Memory Usage: 43.6 MB, less than 6.00% of Java online submissions for Find All Anagrams in a String.
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int length_p = p.length();
        int length = s.length();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        String tmpP = String.valueOf(chars);
        for (int i = 0; i <= length - length_p; i++) {
            String tmp = s.substring(i, i + length_p);
            char[] chars1 = tmp.toCharArray();
            Arrays.sort(chars1);
            String res = String.valueOf(chars1);
            if (tmpP.equals(res)) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }
}
