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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = null; // a-1 th node
        ListNode afterB = null; // b+1 th node
        ListNode current = list1;
        
        int count = 0;
        while (true) {
            count++;
            if (count==a) {
                prevA = current;
            }
            if (count==b+1) {
                afterB = current.next;
                break;
            }
            current=current.next;
        }
        
        ListNode start = list2; //list2 head
        ListNode end = list2; //list2 tail
        while (end.next!=null) {
            end=end.next;          
        }
        
        prevA.next=start;
        end.next=afterB;
        
        return list1;
    }
}