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
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null)
            return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        
        ListNode currOdd=odd,currEven=even;
        ListNode curr = head.next.next;
        while (curr!=null && curr.next!=null) {
            currOdd.next=curr;
            currOdd=currOdd.next;
            currEven.next=curr.next;
            currEven=currEven.next;
            curr=curr.next.next;
        }
        if (curr!=null) {
            currOdd.next=curr;
            currOdd=currOdd.next;
            currEven.next=null;
        }
        
        currOdd.next=even;
        
        return odd;
    }
}