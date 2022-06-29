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

class BSTIterator {
    Stack<TreeNode> stack;
    boolean reverse = true; // Ascending order or descending order

    public BSTIterator(TreeNode root,boolean reverse) {
        this.reverse=reverse; 
        stack = new Stack<>();
        while (root!=null) {
            stack.push(root);
            if (reverse) // Descending
                root=root.right;
            else
                root=root.left;
        }
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        TreeNode temp = reverse ? curr.left : curr.right;
        while(temp!=null) {
            stack.push(temp);
            if (reverse) // Descending
                temp=temp.right;
            else
                temp=temp.left;
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root==null)
            return false;
        
        // Two pointer approach
        BSTIterator left = new BSTIterator(root,false);
        BSTIterator right = new BSTIterator(root,true);
        
        int first = left.next();
        int second = right.next();
        
        while (first<second) {
            if (first+second==k)
                return true;
            else if (first+second>k)
                second=right.next();
            else // first+second<k
                first=left.next();
        }
        
        return false;
    }
}