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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // If both null - true
        if (p==null && q==null)
            return true;
        
        // If one of p and q is null - false
        if (p==null || q==null)
            return false;
        
        return 
            (p.val==q.val) && 
            isSameTree(p.left,q.left) &&
            isSameTree(p.right,q.right);
    }
}