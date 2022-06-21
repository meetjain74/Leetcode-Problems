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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //preorderRecursive(root,ans);
        preorderIterative(root,ans);
        return ans;
    }
    
    /*Recursive implementation*/
    private void preorderRecursive(TreeNode root, List<Integer> ans) {
        if (root==null) {
            return;
        }
        ans.add(root.val);
        preorderRecursive(root.left,ans);
        preorderRecursive(root.right,ans);
    }
    
    /*Iterative implementation using stack*/
    private void preorderIterative(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        while (current!=null || !s.isEmpty()) {
            while (current!=null) {
                s.push(current);
                ans.add(current.val);
                current = current.left;
            }

            current = s.pop();
            current = current.right;
        }
    }
}