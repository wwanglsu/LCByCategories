/*
    思路, 类似 subsets 解法
    因为我们要返回所有可能的分割组合，我们必须要检查所有的可能性，一般来说这就要使用DFS，由于要返回路径，仍然是
    典型的做法：递归时加入一个临时列表，先加入元素，搜索完再去掉该元素。对每一种可能性都调用isPalindrome函数来判
    断。
    
    对原字符串的所有子字符串的访问顺序是什么呢，如果原字符串是 aab, 那么访问顺序为:
                                   ()[a,a,b]
                           /            |           \
                    (a)[a,b]         (aa)[b]      (aab)[]
                   /       \            |
                 (a,a)[b]   (a,ab)     (aa,b)
                 /
                (a,a,b)
    */


public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans =new LinkedList<List<String>>();
        List<String> temp = new LinkedList<String>();
        if(s == null || s.isEmpty()) {
            ans.add(temp);
            return ans;
        }
        
        dfs(ans, temp, s, 0);
        return ans;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    private void dfs(List<List<String>> ans, List<String> temp, String s, int position) {
        if(position == s.length()) {
            ans.add(new LinkedList<String>(temp));
            return;
        }
        
        for(int i = position; i < s.length(); i++) {
            String substring = s.substring(position, i + 1);
            if(isPalindrome(substring)) {
                temp.add(substring);
                dfs(ans, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}