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
    int currentSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        return root;
    }

    // Reverse inorder
    private void inorder(TreeNode root) {
        if (root==null)
            return;
        
        inorder(root.right);
        
        currentSum += root.val;
        root.val = currentSum;
            
        inorder(root.left);
    }
}