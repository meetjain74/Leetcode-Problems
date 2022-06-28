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
    public boolean findTarget(TreeNode root, int k) {
        // Values of Tree
        HashMap<Integer,Boolean> values = new HashMap<>();
        return inorder(values,root,k);
    }
    
    private boolean inorder(HashMap<Integer,Boolean> map,TreeNode root,int k) {
        if (root==null)
            return false;
        
        if (inorder(map,root.left,k))
            return true;
        
        if (map.containsKey(k-root.val)) {
            return true;
        }
        map.put(root.val,true);
        
        if (inorder(map,root.right,k))
            return true;
        
        return false;
    }
}