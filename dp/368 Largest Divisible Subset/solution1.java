/*
Solution2:  DP思路， 用 2个辅助数组，从后往前 遍历.（类似最长增加子序列）
先sort array [1,2,3,8]
定义一个动态数组dp，其中dp[i]表示到数字nums[i]位置最大可整除的子集合的长度，还需要一个一维数组parent，
来保存“后一个能整除的数字的位置"，两个整型变量max和max_idx分别表示最大子集合的长度和起始数字的位置，
我们可以从后往前遍历数组，对于某个数字再遍历到末尾，在这个过程中，如果nums[j]能整除nums[i] (前 除以 后), 
且dp[i] < dp[j] + 1的话，更新dp[i]和parent[i]，如果dp[i]大于mx了，还要更新mx和mx_idx，最后循环结束后，
我们来填res数字，根据parent数组来找到每一个数字。
*/

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(nums==null || nums.length==0) return ans;
        Arrays.sort(nums);
        
        int[] dp = new int[nums.length];
        int[] parent = new int[nums.length];
        int max = 0; //max len
        int maxIdx = -1;
        
        for(int i = nums.length-1; i>=0; i--) {
            for(int j=i; j<nums.length; j++) {
                if(nums[j] % nums[i] == 0 && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                    parent[i] = j;
                    if(dp[i] > max) {
                        max=dp[i];
                        maxIdx = i;
                    }
                }
            }
        }
        
        for(int i = 0; i<max; i++) {
            ans.add(nums[maxIdx]);
            maxIdx = parent[maxIdx];
        }
        //Collections.reverse(ans);
        return ans;
    }
}