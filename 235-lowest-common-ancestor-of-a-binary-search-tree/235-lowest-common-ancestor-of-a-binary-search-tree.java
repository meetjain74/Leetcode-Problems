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
        // If both p and q small than root
        if (root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        
        // If both p and q larger than root
        if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);

        return root;
    }
}