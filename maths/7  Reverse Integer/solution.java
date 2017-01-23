/*
solution 1: 使用long来保存可能溢出的结果，再与最大/最小整数相比较

后续 Follow Up
Q：拿到反转整数题目后第一步是什么？
A：先问出题者尾部有0的数字反转后应该是什么形式，其次问清楚溢出时应该返回什么。
Q：除了检查溢出返回特定值以外，有没有别的方法处理溢出？
A：可以使用try-catch代码块排除异常。
*/

public class Solution {
    public int reverse(int x) {
        boolean isPos = x > 0 ? true : false;
        x = Math.abs(x);
        long reverse = 0;
        
        while(x > 0) {
            reverse = reverse * 10;
            reverse += x % 10;
            if(reverse > Integer.MAX_VALUE) return 0;
            x = x / 10;
        }
        
        return (int)(isPos ? reverse : -reverse);
    }
}