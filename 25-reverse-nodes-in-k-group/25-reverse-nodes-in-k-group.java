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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode demo = head;
        
        if (head==null)
            return head;
        
        int index=0;
        while (demo.next!=null && index<k-1) {
            demo = demo.next;
            index++;
        }
        
        if (index<k-1)
            return head;

        ListNode second = reverseKGroup(demo.next,k);
        
        // Reverse the first K part of this linked list
        ListNode previous,current,future;
        current=head;
        previous=null;
        future=null;

        for (int i=0;i<k;i++) {
            future = current.next;
            current.next=previous;
            previous=current;
            current=future;
        }
        head.next=second;
        head=previous;
        
        return head;
    }
    
    
}