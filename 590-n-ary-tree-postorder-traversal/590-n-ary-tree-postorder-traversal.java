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
        LinkedList<Integer> ans = new LinkedList<>();
        if (root==null)
            return ans;
        
        // Iterative solution
        Stack<Node> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            Node x = s.pop();
            ans.addFirst(x.val);
            for (Node child: x.children) {
                s.add(child);
            }
        }
        
        return ans;
    }
    
    // Recursive
    private void naryPostorder(List<Integer> ans,Node root) {
        if (root==null)
            return;
        
        for (Node child: root.children) {
            naryPostorder(ans,child);
        }
        
        ans.add(root.val);
    }
}