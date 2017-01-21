
/*
Solution 1： 回溯法， DFS
复杂度: 时间 O(NlogN) 空间 O(N) 递归栈空间
深度遍历进去，把每个节点 加入ans， 然后回溯的时候，把 最后一个数组 remove掉
                       [] (1,2,3)
    /                        |                \    
    [1] (2,3)               [2] (3)           [3] ()
    /           \            |
  [1,2] (3)   [1,3] ()      [2,3] ()
    |
  [1,2,3] ()
  
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        List<Integer> temp = new LinkedList<Integer>();
        dfs(nums, ans, temp, 0);
        return ans;
    }
    
    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {
        
        ans.add(new LinkedList<Integer>(temp));
        // i = index, 别混淆
        for(int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, ans, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
    
}