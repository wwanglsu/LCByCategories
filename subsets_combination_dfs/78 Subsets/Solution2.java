
/*
Solution 2： Iterative
用Bits思想，把所有可能结果列出, 3位数字[1,2,3] 各位上用0,1，构成 2^3 = 8:

i        set
0         [] 
1(001)    [1] 
2(010)    [2] 
3(011)    [1, 2] 
4(100)    [3] 
5(101)    [1, 3] 
6(110)    [2, 3] 
7(111)    [1, 2, 3] 

*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        for(int i = 0; i < (1<<nums.length); i++) {
            List<Integer> subset  = new LinkedList<Integer>();
            for(int j = 0; j < nums.length; j++) {
                if((i & (1<<j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            ans.add(subset);
        }
        
        return ans;
    }
    
    
}