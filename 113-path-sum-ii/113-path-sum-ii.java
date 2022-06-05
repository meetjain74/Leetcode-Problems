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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(ans,root,targetSum,temp);
        return ans;
    }
    
    private void helper(List<List<Integer>> ans, TreeNode root, 
                        int targetSum, List<Integer> temp) {
        if (root==null) {
            return;
        }
        
        temp.add(root.val);
        
        if (root.val==targetSum && root.left==null && root.right==null) {
            ans.add(temp);
        }
        
        helper(ans,root.left,targetSum-root.val,new ArrayList<>(temp));
        helper(ans,root.right,targetSum-root.val,new ArrayList<>(temp));
    }
}