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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prevLeft = null;
        while (curr!=null && left!=1) {
            prevLeft=curr;
            curr=curr.next;
            left--;
            right--;
        }
        
        // Reverse linked list between left and right
        ListNode tail = curr; // Tail of reverse list
        
        ListNode prev = null;
        while (curr!=null && right!=0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }
        
        // prev stores the reverse linked list
        if (prevLeft!=null)
            prevLeft.next=prev;
        else
            head=prev;
        
        if (tail!=null)
            tail.next=curr;
        
        return head;
    }
}