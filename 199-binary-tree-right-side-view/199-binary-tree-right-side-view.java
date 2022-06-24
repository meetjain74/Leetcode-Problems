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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //iterativeMethod(ans,root);
        preorder(ans,root,0);
        return ans;
    }
    
    private void iterativeMethod(List<Integer> ans,TreeNode root) {
        // Level order traversal 
        // Each level from right to left
        // First node of each level
        
        if (root==null)
            return;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                TreeNode current = q.poll();
                if (i==0)
                    ans.add(current.val);
                
                if (current.right!=null) 
                    q.add(current.right);
                if (current.left!=null)
                    q.add(current.left);
            }
        }
    }
    
    // Recursive method
    // Do reverse preorder i.e DRL (Data right left)
    private void preorder(List<Integer> ans,TreeNode root,int level) {
        if (root==null)
            return;
        
        // Current value of this level not added yet
        if (level==ans.size())
            ans.add(root.val);
        
        preorder(ans,root.right,level+1);
        preorder(ans,root.left,level+1);
    }
}