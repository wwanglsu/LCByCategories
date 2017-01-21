/*
Solution 2:  类似Subset I，在 ans 中 去 重复  contians() 。


*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0; i < (1<<nums.length); i++) {
            List<Integer> subset = new LinkedList<Integer>();
            for(int j = 0; j<nums.length; j++) {
                if((i & (1<<j)) != 0){
                    subset.add(nums[j]);
                }
            }
            
            if(!ans.contains(subset)){
                ans.add(subset);
            }
        }
        return ans;
    }
    

}