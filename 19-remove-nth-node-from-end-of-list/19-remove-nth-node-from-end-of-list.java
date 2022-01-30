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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int size=1;
        
        while (current.next!=null) {
            size++;
            current=current.next;
        }
        
        if (n==size)
            return head.next;
        
        int i=0;
        current=head;
        while (current.next!=null && i<size-n-1) {
            current = current.next;
            i++;
        }
         
        if (current.next!=null)
            current.next = current.next.next;
        return head;
    }
}