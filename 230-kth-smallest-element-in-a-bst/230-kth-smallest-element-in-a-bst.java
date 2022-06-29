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
    int curr = 0;
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root,k);
    }
    
    private int inorder(TreeNode root,int k) {
        if (root==null)
            return -1;
        
        int left = inorder(root.left,k);
        if (left!=-1)
            return left;
        
        curr++;
        if (curr==k)
            return root.val;
        
        int right = inorder(root.right,k);
        return right;
    }
}