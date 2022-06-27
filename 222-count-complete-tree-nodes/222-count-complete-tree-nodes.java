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
    public int countNodes(TreeNode root) {
        if (root==null)
            return 0;
        
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        
        if (lh==rh) {
            // Tree is complete binary tree
            // No of nodes = 2^h-1
            return (2<<lh)-1;            
        }
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    
    private int getLeftHeight(TreeNode root) {
        int height = 0;
        TreeNode curr = root;
        while (curr.left!=null) {
            height++;
            curr=curr.left;
        }
        return height;
    }
    
    private int getRightHeight(TreeNode root) {
        int height = 0;
        TreeNode curr = root;
        while (curr.right!=null) {
            height++;
            curr=curr.right;
        }
        return height;
    }
}