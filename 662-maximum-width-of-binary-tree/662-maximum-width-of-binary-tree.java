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

class indexedNode {
    TreeNode node;
    int index; // Give each node an index
    
    indexedNode(TreeNode node, int index) {
        this.node=node;
        this.index=index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 1; // Root of tree node - Level 1
        
        // BFS
        Queue<indexedNode> q = new LinkedList<>();
        q.add(new indexedNode(root,1));
        while (!q.isEmpty()) {
            int size = q.size();
            int startId=0;
            int endId=0;
            for (int i=0;i<size;i++) {
                indexedNode current = q.poll();
                if (i==0) {
                    startId=current.index;
                }
                else if (i==size-1) {
                    endId=current.index;
                }
                
                // Left child index is 2*parentIndex
                if (current.node.left!=null)
                    q.add(new indexedNode(current.node.left,2*current.index));
                
                // Right child index is 2*parentIndex+1
                if (current.node.right!=null)
                    q.add(new indexedNode(current.node.right,2*current.index+1));
            }
            
            if (endId!=0)
                maxWidth = Math.max(maxWidth,endId-startId+1);
        }
        
        
        return maxWidth;
    }
}