/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    // Store parent of each node
    HashMap<TreeNode,TreeNode> parent = new HashMap<>();
    
    // Store if node already visited
    HashMap<TreeNode,Boolean> visited = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        updateParentMap(root);
        
        // BFS distance wise from target in all directions- children and parent
        int distance = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target,true);
        while (!q.isEmpty()) {
            if (distance==k)
                break;
            
            int size = q.size();
            
            for (int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                
                // Add left if not already visited
                if (curr.left!=null && visited.get(curr.left)==null) {
                    q.add(curr.left);
                    visited.put(curr.left,true);
                }
                
                // Add right if not already visited
                if (curr.right!=null && visited.get(curr.right)==null) {
                    q.add(curr.right);
                    visited.put(curr.right,true);
                }
                
                // Add parent if not already visited
                TreeNode currParent = parent.get(curr);
                if (currParent!=null && visited.get(currParent)==null) {
                    q.add(currParent);
                    visited.put(currParent,true);
                }
            }
            
            distance++;
        }
        
        // All nodes currently inside queue are the nodes at distance k from target
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
    
    private void updateParentMap(TreeNode root) {
        // BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.left!=null) {
                q.add(curr.left);
                parent.put(curr.left,curr);
            }

            if (curr.right!=null) {
                q.add(curr.right);
                parent.put(curr.right,curr);
            }
        }
    }
}