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
    TreeNode previous = null; // To store the previous node
    public void flatten(TreeNode root) {
        flatten3(root);
    }
    
    // Method 1 : Reverse postorder
    // Time complexity- O(N)
    // Space complexity- O(N)
    private void flatten1(TreeNode root) {
        if (root==null)
            return;
        
        flatten1(root.right);
        flatten1(root.left);
        
        // Node visited - Set right child prev and left child null
        root.right = previous;
        root.left = null;
        previous = root;
    }
    
    
    // Method 2 : Using stack
    // Time complexity- O(N)
    // Space complexity- O(N)
    private void flatten2(TreeNode root) {
        if (root==null)
            return;
        
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            
            if (curr.right!=null)
                s.push(curr.right);
            if (curr.left!=null)
                s.push(curr.left);
            
            // Set right child of current to top of stack
            if (!s.isEmpty())
                curr.right=s.peek();
            
            // Set left child of current to null
            curr.left=null;
        }
    }
    
    
    // Method 3 : Using Morris traversal
    // Time complexity- O(N)
    // Space complexity- O(1)
    private void flatten3(TreeNode root) {
        if (root==null)
            return;
        
        TreeNode curr = root;
        while(curr!=null) {
            if (curr.left!=null) {
                // Find rightmost node in left subtree
                TreeNode prev = curr.left;
                while (prev.right!=null) {
                    prev=prev.right;
                }
                
                prev.right = curr.right; // Threaded connection
                curr.right = curr.left;
                curr.left = null;
            }
            curr=curr.right;
        }
    }
}