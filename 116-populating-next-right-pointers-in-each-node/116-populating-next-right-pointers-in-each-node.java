/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        connect(root,null);
        return root;
    }
    
    private void connect(Node root,Node parent) {
        if (root==null)
            return;
        
        if (parent==null) {
            root.next=null;
        }
        
        // If root is left child of parent
        else if (parent.left==root) {
            root.next=parent.right;
        }
        else if (parent.right==root) {
            if (parent.next!=null)
                root.next=parent.next.left;
            else
                root.next=null;
        }
        
        connect(root.left,root);
        connect(root.right,root);
    }
}