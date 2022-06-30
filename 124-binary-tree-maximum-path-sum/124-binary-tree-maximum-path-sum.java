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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPath(root);
        return maxPath;
    }
    
    // Postorder
    private int getMaxPath(TreeNode root) {
        if (root==null)
            return 0;
        
        int left = getMaxPath(root.left); // Max path in left subtree
        int right = getMaxPath(root.right); // Max path in right subtree
        
        // If left and right contains max path less than 0
        if (left<0) left=0;
        if (right<0) right=0;
        
        // For current node, max path is from left max path to right max path 
        // including this node
        maxPath = Math.max(maxPath,root.val+left+right);
        
        return root.val+Math.max(left,right);
    }
}