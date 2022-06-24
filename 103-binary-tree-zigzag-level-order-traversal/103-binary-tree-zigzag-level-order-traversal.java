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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean shouldReverse = false;
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i=0;i<size;i++) {
                TreeNode current = q.poll();
                temp.add(current.val);
                
                if (current.left!=null)
                    q.add(current.left);
                if (current.right!=null)
                    q.add(current.right);
            }
            if (shouldReverse) {
                Collections.reverse(temp);
            }
            shouldReverse = !shouldReverse;
            ans.add(temp);
        }
        
        return ans;
    }
}