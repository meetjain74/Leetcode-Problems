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
    public void flatten(TreeNode root) {
        flatten1(root);
    }
    
    // Method 1 : Reverse postorder
    // Time complexity- O(N)
    // Space complexity- O(N)
    TreeNode previous = null; // To store the previous node
    private void flatten1(TreeNode root) {
        if (root==null)
            return;
        
        flatten1(root.right);
        flatten1(root.left);
        
        // Node visited - Set right child prev and left child null
        root.right = previous;
        root.left = null;
        previous = root;
    }
}