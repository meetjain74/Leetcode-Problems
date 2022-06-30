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
    
    // Map to store rob money from node i.e [node,rob money]
    HashMap<TreeNode,Integer> map = new HashMap<>();
    
    public int rob(TreeNode root) {
        if (root==null)
            return 0;
        
        if (map.containsKey(root))
            return map.get(root);
        
        // Consider root node is robbed - root left and right cannot be robbed
        int rob1 = root.val;
        if (root.left!=null)
            rob1 += rob(root.left.left) + rob(root.left.right);
        if (root.right!=null)
            rob1 += rob(root.right.left) + rob(root.right.right);
        
        // If root node is node robbed
        int rob2 = rob(root.left) + rob(root.right);
        
        // Money to rob
        int rob = Math.max(rob1,rob2);
        map.put(root,rob);
        
        return rob;
    }
}