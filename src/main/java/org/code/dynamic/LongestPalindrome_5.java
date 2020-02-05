package org.code.dynamic;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p>
 * TODO 理解算法：https://leetcode.com/problems/longest-palindromic-substring/discuss/354582/Java-easy-to-understand-dp-solution-with-comments
 * https://leetcode.com/problems/longest-palindromic-substring/discuss/408930/JAVA%3A-Simple-and-Concise-solution-with-detailed-explanation
 */
public class LongestPalindrome_5 {
    public static void main(String[] args) {
        String str = "lphbehiapswjudnbcossedgioawodnwdruaaxhbkwrxyzaxygmnjgwysafuqbmtzwdkihbwkrjefrsgjbrycembzzlwhxneiijgzidhngbmxwkhphoctpilgooitqbpjxhwrekiqupmlcvawaiposqttsdgzcsjqrmlgyvkkipfigttahljdhtksrozehkzgshekeaxezrswvtinyouomqybqsrtegwwqhqivgnyehpzrhgzckpnnpvajqevbzeksvbezoqygjtdouecnhpjibmsgmcqcgxwzlzztdneahixxhwwuehfsiqghgeunpxgvavqbqrelnvhnnyqnjqfysfltclzeoaletjfzskzvcdwhlbmwbdkxnyqappjzwlowslwcbbmcxoiqkjaqqwvkybimebapkorhfdzntodhpbhgmsspgkbetmgkqlolsltpulgsmyapgjeswazvhxedqsypejwuzlvegtusjcsoenrcmypexkjxyduohlvkhwbrtzjnarusbouwamazzejhnetfqbidalfomecehfmzqkhndpkxinzkpxvhwargbwvaeqbzdhxzmmeeozxxtzpylohvdwoqocvutcelgdsnmubyeeeufdaoznxpvdiwnkjliqtgcmvhilndcdelpnilszzerdcuokyhcxjuedjielvngarsgxkemvhlzuprywlypxeezaxoqfges";
        System.out.println(str.substring(0, 1));
        System.out.println(new LongestPalindrome_5().isPalindrome("aba"));
        System.out.println(new LongestPalindrome_5().longestPalindrome(str));
    }

    /**
     * https://leetcode.com/problems/longest-palindromic-substring/discuss/408930/JAVA%3A-Simple-and-Concise-solution-with-detailed-explanation
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s; // 处理字符串为 "a"
        String result = "";


        return result;
    }

    // given a string and the CENTER(S) of the palindrome (i and i+1), find the longest possible palindrome
    // from center, go left and right till characters are same and return the longest palindromic substring
    private static String palindromeHelper(String string, int begin, int end) {
        while (begin >= 0 && end < string.length() && string.charAt(begin) == string.charAt(end)) {
            begin--;
            end++;
        }
        return string.substring(begin + 1, end);
    }

    /**
     * Time Limit Exceeded
     *
     * @param s
     * @return
     */
    public String longestPalindrome_old(String s) {
        if (s != null && s.length() <= 1) return s; // 处理字符串为 "a"

        String result = "";
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(chars[i]);
            for (int j = i + 1; j < length; j++) {
                builder.append(chars[j]);
                if (isPalindrome(builder.toString())) {
                    result = result.length() > builder.toString().length() ? result : builder.toString();
                }
            }
        }
        if (result.length() == 0) {
            result = chars[0] + "";
        }
        return result;
    }

    public boolean isPalindrome(String str) {
        StringBuilder builder = new StringBuilder(str);
        String tmp = builder.reverse().toString();
        return str.equals(tmp);
    }
}
