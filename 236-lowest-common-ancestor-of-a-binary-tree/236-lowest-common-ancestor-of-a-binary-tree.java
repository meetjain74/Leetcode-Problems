/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If any node p or q is reached
        if (root==null || root==p || root==q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if (left==null) {
            return right;
        }
        else if (right==null) {
            return left;
        }
        
        // Both left and right are not null - current node is the ancestor
        return root;
    }
}