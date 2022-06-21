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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricIterative(root);
    }
    
    // Recursive solution
    private boolean isSymmetricRecursive(TreeNode root) {
        if (root==null)
            return true;
        
        return isMirror(root.left,root.right);
    }
    
    private boolean isMirror(TreeNode x,TreeNode y) {
        if (x==null && y==null)
            return true;
        
        if (x==null || y==null)
            return false;
        
        if (x.val==y.val) {
            return isMirror(x.left,y.right) && isMirror(x.right,y.left);
        }
        
        return false;
    }
    
    // Iterative solution
    private boolean isSymmetricIterative(TreeNode root) {
        if (root==null)
            return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll(); //Of left subtree
            TreeNode y = queue.poll(); // Of right subtree
            
            if(x==null && y==null) {
                continue;
            }

            if(x==null || y==null) {
                return false;
            }

            if(x.val!=y.val) {
                return false;
            }
            
            queue.add(x.left);
            queue.add(y.right);
            
            queue.add(x.right);
            queue.add(y.left);
        }
        
        return true;
    }
}