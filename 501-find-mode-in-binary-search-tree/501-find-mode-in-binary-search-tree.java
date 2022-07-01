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
    int prev = Integer.MIN_VALUE;
    int max = 0;
    int curr = 1;
    
    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>(); // To store modes
        inorder(ans,root);
        int[] res = new int[ans.size()];
        for (int i=0;i<ans.size();i++) {
            res[i]=ans.get(i);
        }
        return res;
    }
    
    private void inorder(List<Integer> ans,TreeNode root) {
        if (root==null)
            return;
        
        inorder(ans,root.left);
        
        if (root.val==prev) {
            curr++;
        }
        else {
            curr=1;
        }
        
        if (curr>max) {
            ans.clear();
            max=curr;
        }
        if (curr==max) {
            ans.add(root.val);
        }
        
        prev=root.val;
        inorder(ans,root.right);
    }
}