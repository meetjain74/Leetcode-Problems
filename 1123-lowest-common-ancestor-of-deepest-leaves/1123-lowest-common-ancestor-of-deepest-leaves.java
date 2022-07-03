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

class INode {
    int depth;
    TreeNode node;
    
    INode(int depth,TreeNode node) {
        this.depth=depth;
        this.node=node;
    }
}


class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return getSubtree(root).node;
    }
    
    private INode getSubtree(TreeNode root) {
        if (root==null)
            return new INode(0,null);
        
        INode left = getSubtree(root.left);
        INode right = getSubtree(root.right);
        
        if (left.depth==right.depth)
            return new INode(left.depth+1,root);
        
        if (left.depth>right.depth)
            return new INode(left.depth+1,left.node);
        
        return new INode(right.depth+1,right.node);
    }
}