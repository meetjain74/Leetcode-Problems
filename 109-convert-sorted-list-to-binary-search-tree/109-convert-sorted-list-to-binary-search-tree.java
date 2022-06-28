/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null)
            return null;
        
        // Find middle element of array
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
        
        while (fast!=null && fast.next!=null) {
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        // Slow node points to middle node now
        
        // Make next of Previous node of slow to null
        // To divide into two independent lists
        if (temp==null) {
            head=null;
        }
        else {
            temp.next=null;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }
}