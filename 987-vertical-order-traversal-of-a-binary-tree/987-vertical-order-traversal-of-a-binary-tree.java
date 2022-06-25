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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        // Map to store column to row to entries
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> tm = 
            new TreeMap<>();
        
        //Performing inorder traversal
        inorder(tm,root,0,0);
        
        // Creating ans from map
        for (TreeMap<Integer, PriorityQueue<Integer>> rowList: tm.values()) {
            List<Integer> temp = new ArrayList<>();
            for (PriorityQueue<Integer> x: rowList.values()) {
                while (!x.isEmpty()) {
                    temp.add(x.poll());
                }
            }
            ans.add(temp);
        }
        
        return ans;
    }
    
    private void inorder
        (TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> tm,
        TreeNode root,int row,int col) {
        if (root==null) {
            return;
        }
        
        inorder(tm,root.left,row+1,col-1);
        
        // Put entry (col,row,root.val) to map
        if (!tm.containsKey(col)) {
            tm.put(col,new TreeMap<>());
        }
        TreeMap<Integer, PriorityQueue<Integer>> temp = tm.get(col);
        if (!temp.containsKey(row)) {
            temp.put(row,new PriorityQueue<>());
        }
        PriorityQueue<Integer> pq = temp.get(row);
        pq.add(root.val);
        
        inorder(tm,root.right,row+1,col+1);
    }
}