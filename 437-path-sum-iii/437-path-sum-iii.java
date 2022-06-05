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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null) {
            return 0;
        }
        
        HashMap<Integer,Integer> possibleSums = new HashMap<>();
        possibleSums.put(0,1);
        countPaths(possibleSums,root,targetSum,0);
        return count;
    }
    
    public void countPaths(HashMap<Integer,Integer> possibleSums, TreeNode root, 
                           int targetSum, int currentSum) {
        if (root==null)
            return;
        
        currentSum += root.val;
        if (possibleSums.containsKey(currentSum-targetSum)) {
            count += possibleSums.get(currentSum-targetSum);
        }
        
        possibleSums.put(currentSum, possibleSums.getOrDefault(currentSum,0)+1); // Add sum to map
        countPaths(possibleSums, root.left, targetSum, currentSum);
        countPaths(possibleSums, root.right, targetSum, currentSum);
        possibleSums.put(currentSum, possibleSums.getOrDefault(currentSum,0)-1); // Remove sum from map
    }
}