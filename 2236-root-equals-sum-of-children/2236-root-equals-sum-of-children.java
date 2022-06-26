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
    public boolean checkTree(TreeNode root) {
        if (root==null)
            return true;
            
        if (root.left==null && root.right==null)
            return true;
         
        int left=0;  
        if (root.left!=null)
            left=root.left.val;
            
        int right=0;
        if (root.right!=null)
            right=root.right.val;
            
        if (left+right!=root.val)
            return false;
            
        return checkTree(root.left) && checkTree(root.right);
    }
}