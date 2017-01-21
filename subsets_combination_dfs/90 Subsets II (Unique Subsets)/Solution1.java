
/*
Solution 1:  类似Subset I，但需要排序，去 重复。

复杂度: 时间 O(NlogN) 空间 O(N) 递归栈空间
深度遍历进去，把每个节点 加入ans， 然后回溯的时候，把 最后一个数组 remove掉
                       [] (1,2,2)
    /                        |                     
    [1] (2,2)               [2] (2)           
    /                        |
  [1,2] (2)                [2,2] ()
    |
  [1,2,2] ()
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        List<Integer> temp = new LinkedList<Integer>();
        Arrays.sort(nums);
        dfs(nums, ans, temp, 0);
        return ans;
    }
    
    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {
        ans.add(new LinkedList<Integer>(temp));
        
        for(int i = index; i < nums.length; i++) {
            //去重复，很重要的条件
            if(i != index && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, ans, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
