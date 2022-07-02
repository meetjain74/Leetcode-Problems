/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        naryPostorder(ans,root);
        return ans;
    }
    
    private void naryPostorder(List<Integer> ans,Node root) {
        if (root==null)
            return;
        
        for (Node child: root.children) {
            naryPostorder(ans,child);
        }
        
        ans.add(root.val);
    }
}