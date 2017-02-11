/*
solution 2: 字符串法
复杂度: 时间 O(n) 空间 O(n)

思路
先将数字转化为字符串，然后将字符串倒序输出，并转回数字。记得需要去除首部多余的0。
*/

public class Solution {
    public int reverse(int x) {
        boolean isPos = x > 0 ? true : false;
        if(x / 10 == 0) return x;
        
       String str = String.valueOf(x);
        StringBuilder sb = null;
        if(!isPos){
            sb = new StringBuilder(str.substring(1));
        }else{
            sb = new StringBuilder(str);
        }
        
        sb.reverse();
        //count number of 0 in prefix 
        int zero = 0;
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '0') {
                zero++;
            } else {
                break;
            }
        }
        str = sb.substring(zero);
        int ans = Long.parseLong(str) > Integer.MAX_VALUE ? 0 : Integer.parseInt(str);
        return isPos ? ans : -ans;
    }
}