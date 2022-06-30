/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        
        // Map stores sum and its frequency
        HashMap<Integer,Integer> map = new HashMap<>();
        getTreeSum(map,root);
        
        List<Integer> ans = new ArrayList<>();
        int maxFreq = -1;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (entry.getValue()>maxFreq) {
                maxFreq=entry.getValue();
                ans.clear();
                ans.add(entry.getKey());
            }
            else if (entry.getValue()==maxFreq) {
                ans.add(entry.getKey());
            }
        }
        
        int[] res = new int[ans.size()];
        for (int i=0;i<ans.size();i++) {
            res[i]=ans.get(i);
        } 
        
        return res;
    }
    
    private int getTreeSum(HashMap<Integer,Integer> map,TreeNode root) {
        if (root==null)
            return 0;
        
        int left = getTreeSum(map,root.left);
        int right = getTreeSum(map,root.right);
        
        int sum = root.val+left+right;
        map.put(sum,map.getOrDefault(sum,0)+1);
        
        return sum;
    }
}