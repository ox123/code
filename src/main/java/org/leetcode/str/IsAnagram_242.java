package org.leetcode.str;

import java.util.Arrays;

public class IsAnagram_242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new IsAnagram_242().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars);
        return String.valueOf(chars).equals(String.valueOf(chars1));
    }

    public boolean isAnagram1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int arr[] = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int counter :
                arr) {
            if (counter != 0) return false;
        }
        return true;
    }
}
