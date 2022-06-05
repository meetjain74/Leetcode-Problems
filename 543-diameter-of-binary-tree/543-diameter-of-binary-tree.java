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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    
    // Returns heights of tree and also updates maximum
    public int helper(TreeNode root) {
        if (root==null)
            return 0;
        
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        
        max = Math.max(max,leftHeight+rightHeight);
        
        return 1+Math.max(leftHeight,rightHeight);
    }
}