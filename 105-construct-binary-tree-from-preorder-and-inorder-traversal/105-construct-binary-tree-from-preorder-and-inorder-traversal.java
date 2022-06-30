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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store index of each element in inorder
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        
        TreeNode root = buildTree(map,preorder,inorder,
                                  0,preorder.length-1,0,inorder.length-1);
        return root;
    }
    
    private TreeNode buildTree(HashMap<Integer,Integer> map,int[] preorder,
                              int[] inorder,int preStart,int preEnd,
                              int inStart,int inEnd) {
        
        if (preStart>preEnd || inStart>inEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // Index of this value in inorder
        int index = map.get(root.val);
        
        root.left = buildTree(map,preorder,inorder,
                              preStart+1,preStart+index-inStart,inStart,index-1);
        
        root.right = buildTree(map,preorder,inorder,
                              preStart+index-inStart+1,preEnd,index+1,inEnd);
        
        return root;
    }
}