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
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        if (root==null)
            return 0;
        
        int left = longestZigZag(root.left,true);
        int right = longestZigZag(root.right,false);
        
        ans = Math.max(ans,Math.max(left,right));
        return ans;
    }
    
    // isLeft is true if previous is left otherwise false
    private int longestZigZag(TreeNode root,boolean isLeft) {
        if (root==null)
            return 0;
        
        int left = longestZigZag(root.left,true);
        int right = longestZigZag(root.right,false);
        
        ans = Math.max(ans,Math.max(left,right));
        
        int curr = 0;
        if (isLeft) {
            curr = 1+right;
        }
        else {
            curr = 1+left;
        }
        
        return curr;
    }
}