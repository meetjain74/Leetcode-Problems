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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length-1);
    }
    
    private TreeNode constructMaximumBinaryTree(int[] nums,int low,int high) {
        if (low>high)
            return null;
        
        if (low==high)
            return new TreeNode(nums[low]);
        
        int max = nums[low];
        int maxIndex = low;
        for (int i=low+1;i<=high;i++) {
            if (max<nums[i]) {
                max=nums[i];
                maxIndex=i;
            }
        }
        
        TreeNode root = new TreeNode(max);
        root.left=constructMaximumBinaryTree(nums,low,maxIndex-1);
        root.right=constructMaximumBinaryTree(nums,maxIndex+1,high);
        
        return root;
    }
}