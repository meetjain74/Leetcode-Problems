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
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        
        if (head==null)
            return head;
        
        while(current.next!=null) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = head;
            head = temp;
        }
        
        return head;
    }
}