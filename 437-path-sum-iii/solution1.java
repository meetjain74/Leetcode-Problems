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
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null) {
            return 0;
        }
        
        int count = countPaths(root, targetSum) + 
            pathSum(root.left, targetSum) + 
            pathSum(root.right, targetSum);
        
        return count;
    }
    
    public int countPaths(TreeNode root, int targetSum) {
        if (root==null)
            return 0;
        
        int count = 0;
        if (root.val==targetSum)
            count++;
        
        targetSum = targetSum - root.val;
        return count+countPaths(root.left, targetSum)+countPaths(root.right, targetSum);
    }
}
