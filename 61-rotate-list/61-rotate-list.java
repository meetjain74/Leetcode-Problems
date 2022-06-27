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
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null)
            return null;
        
        int size = getSize(head);
        k = k%size;
        
        if (k==0)
            return head;
        
        ListNode newHead = head;
        ListNode prev = null;
        int count = 0;
        while (count!=size-k) {
            prev=newHead;
            newHead = newHead.next;
            count++;
        }
        prev.next=null;
        
        ListNode current = newHead;
        while (current.next!=null) {
            current = current.next;
        }
        current.next=head;
        
        return newHead;
    }
    
    private int getSize(ListNode head) {
        int count = 0;
        while (head!=null) {
            head=head.next;
            count++;
        }
        return count;
    }
}