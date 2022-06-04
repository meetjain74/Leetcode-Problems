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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,root,0);
        return ans;
    }
    
    private void helper(List<List<Integer>> ans,TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (ans.size() <= level) {
            List<Integer> l = new ArrayList<>();
            l.add(node.val);
            ans.add(l);
        } 
        else {
            List<Integer> l = ans.get(level);
            l.add(node.val);
        }
        helper(ans,node.left,level+1);
        helper(ans,node.right,level+ 1);

    }
}