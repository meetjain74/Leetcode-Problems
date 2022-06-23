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
    public boolean isValidBST(TreeNode root) {
        return method1(root);
    }
    
    // Inorder traversal of valid bst should be in ascending order
    private boolean method1(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        int currentMin = Integer.MIN_VALUE;
        TreeNode current = root;
        
        // To reach at the first min value in tree
        boolean firstMinValueReached = false; 
        
        while (current!=null || !s.isEmpty()) {
            if (current!=null) {
                s.push(current);
                current=current.left;
            }
            else {
                // Here, current is null 
                current=s.pop();
                if (!firstMinValueReached) {
                    firstMinValueReached=true;
                    currentMin=current.val;
                }
                else if (current.val<=currentMin) {
                    return false;
                }
                currentMin=current.val;
                current=current.right;
            }
        }
        
        return true;
    }
}