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
    public ListNode partition(ListNode head, int x) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode greater = null;
        ListNode curr2 = null;
        
        while (curr!=null) {
            if (curr.val>=x) {
                if (curr2==null) {
                    curr2 = curr;
                    greater = curr2;
                }
                else {
                    curr2.next=curr;
                    curr2=curr2.next;
                }
                curr = curr.next;
                if (curr2==head) {
                    head=head.next;
                }
                curr2.next=null;
            }
            else {
                if (prev==null) {
                    prev=curr;
                }
                else  {
                    prev.next=curr;
                    prev=prev.next;
                }
                curr = curr.next;
            }
        } 
        
        if (prev==null)
            return greater;
        
        prev.next=greater;
        return head;
    }
}