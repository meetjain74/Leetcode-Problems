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
    public ListNode removeElements(ListNode head, int val) {
        if (head==null)
            return head;
        
        if (head.val==val)
            return removeElements(head.next,val);
        
        head.next = removeElements(head.next,val);
        return head;
    }
}