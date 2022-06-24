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
    int lastLevel = -1;
    int leftVal = 0;
    public int findBottomLeftValue(TreeNode root) {
        preorder(root,0);
        return leftVal;
    }
    
    private void preorder(TreeNode root,int level) {
        if (root==null)
            return;
        
        if (level>lastLevel) {
            lastLevel=level;
            leftVal=root.val;
        }
        
        preorder(root.left,level+1);
        preorder(root.right,level+1);
    }
}