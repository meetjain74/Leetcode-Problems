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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null)
            return root;
        
        if (root.val>key) 
            root.left=deleteNode(root.left,key);
        else if (root.val<key)
            root.right=deleteNode(root.right,key);
        
        else {
            // Here, root.val==key -> delete this root node
            
            // If root has only one children
            if (root.left==null)
                return root.right;
            else if (root.right==null)
                return root.left;
            
            // Both left and right child exists
            // Replace value by successor of current node and delete the successor node
            root.val = successor(root);
            root.right=deleteNode(root.right,root.val);
        }
        
        return root;
    }
    
    private int successor(TreeNode root) {
        // Successor of current node is min value in right subtree
        if (root.right==null)
            return -1;
        
        TreeNode current = root.right;
        while(current.left!=null) {
            current=current.left;
        }
        
        return current.val;
    }
}