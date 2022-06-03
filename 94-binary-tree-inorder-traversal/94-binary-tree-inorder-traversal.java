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
        //inorderRecursive(root,ans);
        inorderIterative(root,ans);
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
    
    /*Iterative implementation using stack*/
    private void inorderIterative(TreeNode root, List<Integer> ans) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        while (current!=null || !s.isEmpty()) {
            while (current!=null) {
                s.push(current);
                current = current.left;
            }

            current = s.pop();
            ans.add(current.val);
            current = current.right;
        }
    }
}