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
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        
        // Pass first half linked list nodes to stack
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast!=null && fast.next!=null) {
            st.push(slow);
            slow=slow.next;
            fast=fast.next.next;
        }
        
        if (fast!=null) // Odd no of elements
            slow=slow.next;
            
        while (slow!=null) {
            if (st.pop().val!=slow.val)
                return false;
            slow=slow.next;
        }
        
        return true;
    }
}