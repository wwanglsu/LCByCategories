/*
Solution 1: 最高位与最低位，一一比较。
比如 1221 这个数字，如果 计算 1221 / 1000， 则可得首位1， 如果 1221 % 10， 则可得到末尾1，
进行比较， 然后把中间的22取出继续比较。

*/

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        //get most significat number
        int div = 1;
        while(x / div >= 10) {
            div = div * 10;
        }
        
        //traverse the number and compare most significat and least significat digits
        while(x > 0) {
            int left = x % 10;
            int right = x / div;
            if(left != right) {
                return false;
            }
            x = (x % div) / 10;;
            div = div / 100;
        }
        
        return true;
    }
}