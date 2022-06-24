/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode cloneTarget = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        inorder(original,cloned,target);
        return cloneTarget;
    }
    
    private boolean inorder(TreeNode original,TreeNode cloned,TreeNode target) {
        if (original==null || target==null)
            return false;
        
        if (original==target) {
            cloneTarget = cloned;
            return true;
        }
        
        if (inorder(original.left,cloned.left,target))
            return true;
        if (inorder(original.right,cloned.right,target))
            return true;
        return false;
    }
}