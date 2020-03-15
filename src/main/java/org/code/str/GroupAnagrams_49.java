package org.code.str;


import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String [] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams_49().groupAnagrams(arr));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String ss :
                strs) {
            char[] tmpValue = ss.toCharArray();
            Arrays.sort(tmpValue);
            String tmp = String.valueOf(tmpValue);
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }
            map.get(tmp).add(ss);

        }
        return new ArrayList<>(map.values());
    }
}
