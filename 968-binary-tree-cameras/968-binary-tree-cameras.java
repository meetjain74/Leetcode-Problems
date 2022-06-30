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
    int camera = 0; // Min camera required
    
    public int minCameraCover(TreeNode root) {
        if (installCamera(root)==2) //Root node not watched, install camera 
            camera++;
        return camera;
    }
    
    // Returns status of node
    // 0 represents node contains camera
    // 1 represents node does not contain camera but is watched
    // 2 represents node does not contain camera and is not watched
    private int installCamera(TreeNode root) {
        if (root==null)
            return 1;
        
        int left = installCamera(root.left);
        int right = installCamera(root.right);
        
        // If left or right are not being watched, install camera here
        // 22 12 21 02 20
        if (left==2 || right==2) {
            camera++;
            return 0;
        }
        
        // If camera exists at left or right, this node does not require camera
        // 00 01 10
        if (left==0 || right==0)
            return 1;
        
        // Both left and right are watched but does not contain camera
        // 11
        return 2;
    }
}