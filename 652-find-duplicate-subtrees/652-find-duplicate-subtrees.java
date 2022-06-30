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
    // Map to store subtree details and all corresponding nodes
    HashMap<String,List<TreeNode>> map = new HashMap<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getTreeDetails(map,root);
        
        List<TreeNode> ans = new ArrayList<>();
        for (List<TreeNode> x: map.values()) {
            if (x.size()>=2)
                ans.add(x.get(0));
        }
        
        return ans;
    }
    
    private String getTreeDetails(HashMap<String,List<TreeNode>> map,TreeNode root) {
        if (root==null)
            return "n ";
        
        String left = getTreeDetails(map,root.left);
        String right = getTreeDetails(map,root.right);
        
        String tree = root.val+" "+left+right;
        
        if (!map.containsKey(tree)) {
            map.put(tree,new ArrayList<TreeNode>());
        }
        List<TreeNode> temp = map.get(tree);
        temp.add(root);
        
        return tree;
    }
}