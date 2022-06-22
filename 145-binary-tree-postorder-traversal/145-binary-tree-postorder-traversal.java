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
        //postorderIterative1(root,ans);
        //postorderIterative2(root,ans);
        postorderMorrisTraversal(root,ans);
        return ans;
    }
    
    /*Recursive implementation*/
    private void postorderRecursive(TreeNode root, List<Integer> ans) {
        if (root==null) {
            return;
        }
        postorderRecursive(root.left,ans);
        postorderRecursive(root.right,ans);
        ans.add(root.val);
    }
    
    /*Iterative implementation using stack*/
    // Using two stacks
    private void postorderIterative1(TreeNode root, List<Integer> ans) {
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
    
    /*Iterative implementation using stack*/
    // Using one stack
    private void postorderIterative2(TreeNode root, List<Integer> ans) {
        if (root==null) {
            return;
        }
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode current = root;
        
        while (current!=null || !s.isEmpty()) {
            if (current!=null) {
                s.push(current);
                current=current.left;
            }
            else {
                // Current node is null - move to parent
                TreeNode parent = s.peek();
                
                // First right part of parent is traversed
                if (parent.right!=null) {
                    current=parent.right;
                }
                else {
                    // Parent has no right child
                    parent = s.pop();
                    ans.add(parent.val);
                    
                    // Move again top
                    while (!s.isEmpty() && parent==s.peek().right) {
                        parent = s.pop();
                        ans.add(parent.val);
                    }
                }
            }
        }
    }
    
    
    /*Morris traversal*/
    private void postorderMorrisTraversal(TreeNode root, List<Integer> ans) {
        TreeNode current = root;
        
        while (current!=null) {
            // If current does not have a right print current and move to left
            if (current.right==null) {
                ans.add(current.val);
                current = current.left;
            }
            
            // Else before moving to right make a threaded connection
            else {
                // Get leftmost node in right subtree
                TreeNode prev = current.right;
                while (prev.left!=null && prev.left!=current) {
                    prev = prev.left;
                }
                
                if (prev.left==null) {
                    // Make threaded connection
                    prev.left = current;
                    ans.add(current.val);
                    current = current.right;
                }
                else {
                    // Remove threaded connection - Restore tree
                    prev.left = null;
                    current = current.left;
                }
            }
        }
        
        Collections.reverse(ans);
    }
}