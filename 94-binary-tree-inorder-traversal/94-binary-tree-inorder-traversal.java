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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderRecursive(root,ans);
        return ans;
    }
    
    /*Recursive implementation*/
    private void inorderRecursive(TreeNode root, List<Integer> ans) {
        if (root==null) {
            return;
        }
        inorderRecursive(root.left,ans);
        ans.add(root.val);
        inorderRecursive(root.right,ans);
    }
}