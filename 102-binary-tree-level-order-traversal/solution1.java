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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null)
            return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            q.add(null); // For differentiating between levels
            TreeNode current = q.poll();
            List<Integer> temp = new ArrayList<>();
            
            while(current!=null) {
                temp.add(current.val);
                if (current.left!=null) 
                    q.add(current.left);
                if (current.right!=null)
                    q.add(current.right);
                current = q.poll();
            }
            ans.add(temp);
        }
        
        return ans;
    }
}
