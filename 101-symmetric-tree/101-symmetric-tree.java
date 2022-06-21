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
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        
        return isMirror(root.left,root.right);
    }
    
    private boolean isMirror(TreeNode x,TreeNode y) {
        if (x==null && y==null)
            return true;
        
        if (x==null || y==null)
            return false;
        
        if (x.val==y.val) {
            return isMirror(x.left,y.right) && isMirror(x.right,y.left);
        }
        
        return false;
    }
}