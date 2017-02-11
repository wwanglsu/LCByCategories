/*
Solution 2:  using KMP  next[] thought. time:  O(n)
        a a b a  a b a a
next[]: 0 1 0 1  2 3 1 2
比如aaba，翻转后得到abaa，然后拼接起来得到aabaabaa，其最长公共前后缀是aa，
去掉这个后缀的反转字符串是ab，再接到原字符串上就是abaaba，即最短的回文拼接。
*/

public class Solution {
    public String shortestPalindrome(String s) {
        if(s==null || s.length() <= 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().substring(0, s.length() - getCommonLength(s)) + s;
    }
    
    private int getCommonLength(String pattern) {
        StringBuilder builder = new StringBuilder(pattern);
        String reverse = new StringBuilder(pattern).reverse().toString();
        builder.append("#").append(reverse);
        
        int[] next = new int[builder.length()];
        for(int i = 1; i < next.length; i++) {
            int longestCommonLength = next[i - 1];
            while(longestCommonLength > 0 && builder.charAt(i) != builder.charAt(longestCommonLength)) {
                longestCommonLength = next[longestCommonLength-1];
            }
            next[i] = longestCommonLength==0 ? (builder.charAt(0)==builder.charAt(i) ? 1:0) :
                        (longestCommonLength + 1);
        }
        return next[next.length - 1];
    }
}