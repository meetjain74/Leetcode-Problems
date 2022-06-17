/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA!=currB) {
            currA = currA==null ? headB : currA.next; // List A -> null -> List B
            currB = currB==null ? headA : currB.next; // List B -> null -> List A
        }
        
        return currA;
    }
}