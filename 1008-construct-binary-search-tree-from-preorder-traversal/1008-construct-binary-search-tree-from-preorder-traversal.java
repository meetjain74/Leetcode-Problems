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
    int current = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,Integer.MAX_VALUE);
    }
    
    private TreeNode bstFromPreorder(int[] preorder,int upperBound) {
        if (current==preorder.length || preorder[current]>upperBound)
            return null;
        
        TreeNode root = new TreeNode(preorder[current++]);
        root.left = bstFromPreorder(preorder,root.val);
        root.right = bstFromPreorder(preorder,upperBound);
        
        return root;
    }
}