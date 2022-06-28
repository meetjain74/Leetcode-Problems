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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Reverse the postorder
        reverse(postorder); // Now becomes - data right left
        
        // Store index of each element in inorder
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        
        TreeNode root = buildTree(map,inorder,postorder,
                                  0,inorder.length-1,0,postorder.length-1);
        return root;
    }
    
    private void reverse(int[] nums) {
        int n=nums.length;
        int temp;
        for (int i=0;i<n/2;i++) {
            // swap nums[i] and nums[n-i-1]
            temp = nums[i];
            nums[i] = nums[n-i-1];
            nums[n-i-1] = temp;
        }
    }
    
    private TreeNode buildTree(HashMap<Integer,Integer> map,int[] inorder,
                              int[] postorder,int inStart,int inEnd,
                              int postStart,int postEnd) {
        
        if (postStart>postEnd || inStart>inEnd) 
            return null;
        
        TreeNode root = new TreeNode(postorder[postStart]);
        
        // Index of this value in inorder
        int index = map.get(root.val);
        int numsLeft = index-inStart; // No of elements in left to index of inorder
        
        root.left = buildTree(map,inorder,postorder,
                             inStart,index-1,postEnd-numsLeft+1,postEnd);
        
        root.right = buildTree(map,inorder,postorder,
                              index+1,inEnd,postStart+1,postEnd-numsLeft);
        
        return root;
    }
}