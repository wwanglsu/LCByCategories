/*
Solution 2: reverse the number, 判断reverse==origin。
假设  数字不会溢出。
注意： 这道题类似 7 reverse Integer。
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        int reverse = 0, origin = x;
        while(x > 0) {
            reverse = reverse * 10;
            reverse += x % 10;
            x = x / 10;
        }
        
        return reverse == origin;
    }
}