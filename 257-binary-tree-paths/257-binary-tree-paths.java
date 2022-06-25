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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(ans,root,"");
        return ans;
    }
    
    private void helper(List<String> ans,TreeNode root,String temp) {
        if (root==null)
            return;
        
        if (!isLeaf(root)) {
            temp = temp + root.val + "->";
            helper(ans,root.left,temp);
            helper(ans,root.right,temp);
        }
        else {
            temp = temp + root.val;
            ans.add(temp);
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        if (node.left==null && node.right==null)
            return true;
        return false;
    }
}