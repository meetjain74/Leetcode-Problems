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

class INode {
    int sum; // sum of nodes in subtree
    int smallest; // smallest node value in subtree
    int largest; // largest node value in subtree
    
    INode(int sum,int smallest,int largest) {
        this.sum=sum;
        this.smallest=smallest;
        this.largest=largest;
    }
}

class Solution {
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        getMaxSumBST(root);
        return maxSum;
    }
    
    // Postorder
    private INode getMaxSumBST(TreeNode root) {
        if (root==null)
            return new INode(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        
        INode left = getMaxSumBST(root.left);
        INode right = getMaxSumBST(root.right);
        
        // If left or right subtree is not a BST
        if (left==null || right==null)
            return null;
        
        // For tree to be BST node value should be greater than
        // left largest and smaller than right smallest
        
        if (root.left==null && root.right==null) {
            // Leaf node is a BST
            maxSum = Math.max(maxSum,root.val);
            return new INode(root.val,root.val,root.val);
        }
        
        int sum = root.val+left.sum+right.sum;
        
        if (root.val>left.largest && root.val<right.smallest) {
            // Subtree is BST
            maxSum = Math.max(maxSum,sum);
            int smallest = Math.min(root.val,left.smallest);
            int largest = Math.max(root.val,right.largest);
            return new INode(sum,smallest,largest);
        }
        
        // Not a BST
        return null;
    }
}