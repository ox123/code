package org.leetcode.str;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_17 {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String [] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int length = 0;
        if (digits ==null || (length = digits.length())==0){
            return res;
        }
        for (int i = 0; i < length; i++) {
            int value = Character.getNumericValue(digits.charAt(i));

        }
        return res;
    }
}
