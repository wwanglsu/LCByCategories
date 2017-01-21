/*
Solution:  DP思路， 用 TreeMap，从前往后 遍历，
先sort array [1,2,3,8]
TreeMap key是每个数组元素，value是一个 pair （len, previous element）
1  [1,-1]
2  [2,1]
3  [2,1]
8  [3, 2]
*/

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(nums==null || nums.length==0) return ans;
        Arrays.sort(nums);
        TreeMap<Integer, int[]> map = new TreeMap<Integer, int[]>();
        int max = 0; //max len
        int maxNum = -1;
        
        for(int num : nums) {
            int len = 1;
            int previousElement = -1;
            for(Integer d : map.keySet()) {
                if(num % d == 0) {
                    if(len < map.get(d)[0] + 1) {
                        len = map.get(d)[0] + 1;
                        previousElement = d;
                    }
                }
            }
            
            if(len > max) {
                max = len;
                maxNum = num;
            }
            map.put(num, new int[]{len, previousElement});
        }
        
        for(int i = max-1; i>=0; i--) {
            ans.add(maxNum);
            maxNum = map.get(maxNum)[1];
        }
        Collections.reverse(ans);
        return ans;
    }
}