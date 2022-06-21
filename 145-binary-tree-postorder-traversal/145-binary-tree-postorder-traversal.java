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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //postorderRecursive(root,ans);
        postorderIterative(root,ans);
        return ans;
    }
    
    /*Recursive implementation*/
    private void postorderRecursive(TreeNode root, List<Integer> ans) {
        if (root==null) {
            return;
        }
        //postorderRecursive(root.left,ans);
        postorderIterative(root.right,ans);
        ans.add(root.val);
    }
    
    /*Iterative implementation using stack*/
    // Using two stacks
    private void postorderIterative(TreeNode root, List<Integer> ans) {
        if (root==null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> out = new Stack<>(); // Stores the postorder
        
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode current = s.pop();
            out.push(current);
            
            if (current.left!=null)
                s.push(current.left);
            
            if (current.right!=null)
                s.push(current.right);
        }
        
        while (!out.isEmpty()) {
            ans.add(out.pop().val);
        }
    }
}