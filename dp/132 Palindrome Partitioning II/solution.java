/*
    动态规划。维护一个boolean[][] dp二维数组，dp[i][j]表示s.substring(i, j)
    是否为回文串。递推公式：检查s.charAt(begin)和s.charAt(end)是否相等，如果相等就检查
    dp[begin + 1][end - 1]的值，也就是对一个dp[begin][end]的赋值复杂度是O(1)。
    另外维护一个cut数组，cut[i]表示分割s.substring(1, i)最少需要几个cut，
    这个值需要在每次找到一个回文串的时候就相应的更新一遍。
    简单来说，就是找出所有的回文串，找的方法就是先判断当前起点和终点字符串是否相等，
    如果相等就进一步检查起点和终点之间的字符串是否是回文的，找到了回文串之后表示从当前起点前的
    位置到当前终点只需切一刀即可分割，以此与已有的分割方案进行比较即可。
    
    a   b   a   |   c  c
                    j  i
       j-1  |  [j, i] is palindrome
   cut(j-1) +  1
   
    */

public class Solution {
    public int minCut(String s) {
        if(s == null || s.isEmpty()) return 0;
        
        int length = s.length();
        //dp[i][j]表示s.substring(i, j) 是否为回文串
        boolean[][] dp = new boolean[length][length];
        int[] cut = new int[length];
        
        for(int end = 0; end < length; end++) {
            int min = end;
            for(int begin = end; begin >= 0; begin--) {
                if(s.charAt(end) == s.charAt(begin) && (end-begin < 2 || dp[begin+1][end-1])) {
                    dp[begin][end] = true;
                    min = begin==0 ? 0 : Math.min(min, cut[begin-1]+1); 
                }
            }
            //cut[i]表示分割s.substring(1, i)最少需要几个cut,
            //这个值需要在每次找到一个回文串的时候就相应的更新一遍
            cut[end] = min;
        }
        
        return cut[length-1];
    }
}