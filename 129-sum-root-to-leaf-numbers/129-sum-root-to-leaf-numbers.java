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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root==null)
            return 0;
        
        preorder(root,0);
        return sum;
    }
    
    private void preorder(TreeNode root,int pathNum) {
        if (root==null)
            return;
        
        pathNum += root.val;
        if (isLeaf(root)) {
            sum+=pathNum;
            return;
        }
        
        preorder(root.left,pathNum*10);
        preorder(root.right,pathNum*10);
    }
    
    private boolean isLeaf(TreeNode root) {
        if (root.left==null && root.right==null)
            return true;
        return false;
    }
}