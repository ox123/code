package org.code.str;

/**
 * TODO 可以使用kmp算法解决，最有解
 */
public class SubStringCount {
    public static void main(String[] args) {
        // write your code here
        String str= "abcabcabca";
        String sub = "abca";
        String str1= "today is nice . may nice day you have";
        String sub1 = "nice";
        System.out.println(new SubStringCount().subString(str, sub));
        System.out.println(new SubStringCount().subString(str1, sub1));
    }

    public int subString(String str, String sub){
        int count = 0;
        int strLength = str.length();
        int subLength = sub.length();
        for (int i = 0; i < strLength; i++) {
            int j = i;
            int k = 0;
            while (j < strLength && k < subLength){
                if (str.charAt(j) == sub.charAt(k)){
                    j++;
                    k++;
                    if(k == subLength-1){
                        count++;
                    }
                }else{
                    break;
                }
            }
        }
        return count;
    }
}
