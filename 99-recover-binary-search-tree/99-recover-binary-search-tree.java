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
    TreeNode wrong1 = null;
    TreeNode wrong2 = null;
    TreeNode temp = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        // swap wrong1 and wrong2 values
        int t = wrong1.val;
        wrong1.val = wrong2.val;
        wrong2.val = t;
    }
    
    private void inorder(TreeNode root) {
        if (root==null)
            return;
        
        inorder(root.left);
        
        if (root.val<temp.val) {
            if (wrong1==null) {
                wrong1=temp;
                wrong2=root;
            }
            else {
                wrong2=root;
            }
        }
        
        temp=root;
        
        inorder(root.right);
    }
}