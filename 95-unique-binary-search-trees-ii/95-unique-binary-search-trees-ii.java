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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] memo= new ArrayList[n+1][n+1];
        return generateTrees(memo,1,n);
    }
    
    private List<TreeNode> generateTrees(List<TreeNode>[][] memo,int start,int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start>end) {
            list.add(null);
            return list;
        }
        
        // If list already contains tree
        if (memo[start][end]!=null)
            return memo[start][end];
        
        // Considering each node from start to end as root once
        for (int i=start;i<=end;i++) {
            // Root will have value i
            // Root left will have value from start to i-1
            // Root right will have values from i+1 to end
            List<TreeNode> left = generateTrees(memo,start,i-1);
            List<TreeNode> right = generateTrees(memo,i+1,end);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode curr = new TreeNode(i);
                    curr.left=l;
                    curr.right=r;
                    list.add(curr);
                }
            }
            
        }
        
        memo[start][end]=list;
        return list;
    }
}