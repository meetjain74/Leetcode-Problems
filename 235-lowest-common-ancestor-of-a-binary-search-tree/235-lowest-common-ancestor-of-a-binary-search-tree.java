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
        
        if (p.val==root.val) return p;
        if (q.val==root.val) return q;
        
        // If p and q are opposite sides of root
        if ((p.val>root.val && q.val<root.val) ||
           (p.val<root.val && q.val>root.val)) {
            return root;
        }
        
        // If both are small
        if (p.val<root.val && q.val<root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        
        // If both are big
        return lowestCommonAncestor(root.right,p,q);
    }
}