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
    // Store result in map
    // Index 0 - Prev left and Index 1 - Prev right
    HashMap<TreeNode,int[]> map = new HashMap<>();
    
    public int longestZigZag(TreeNode root) {
        if (root==null)
            return 0;
        
        int left = longestZigZag(root.left,true);
        int right = longestZigZag(root.right,false);
        
        int max = Math.max(left,right);
        
        left = longestZigZag(root.left);
        right = longestZigZag(root.right);
        
        max = Math.max(max,Math.max(left,right));
        
        return max;
    }
    
    // left is true if previous is left otherwise false
    private int longestZigZag(TreeNode root,boolean left) {
        if (root==null)
            return 0;
        
        int index = left ? 0 : 1;
        if (map.containsKey(root) && map.get(root)[index]!=-1)
            return map.get(root)[index];
        
        int curr = 0;
        if (left) {
            curr = 1+longestZigZag(root.right,false);
        }
        else {
            curr = 1+longestZigZag(root.left,true);
        }
        
        if (!map.containsKey(root)) {
            map.put(root,new int[]{-1,-1});    
        }
        int[] val = map.get(root);
        val[index] = curr;
        
        return curr;
    }
}