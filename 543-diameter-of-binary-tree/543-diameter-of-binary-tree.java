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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) 
            return 0;
        
        int diameterLeftSubtree = diameterOfBinaryTree(root.left);
        int diameterRightSubtree = diameterOfBinaryTree(root.right);
        int maxPathThroughRoot = height(root.left)+height(root.right);
        
        int ans = Math.max(maxPathThroughRoot,
                          Math.max(diameterLeftSubtree,diameterRightSubtree));
        
        return ans;
    }
    
    public int height(TreeNode root) {
        if (root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}