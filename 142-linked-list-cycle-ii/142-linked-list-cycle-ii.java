/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null) 
            return null;
        
        // Using floyd cycle detection algorithm
        ListNode slow = head;
        ListNode fast = head;
        
        boolean cycleExists = false;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow==fast) {
                cycleExists=true;
                break;
            }
        }
        
        if (!cycleExists)
            return null;
        
        // Now slow and fast both point to the same node
        ListNode cycleNode = head;
        
        while (cycleNode!=fast) {
            cycleNode=cycleNode.next;
            fast=fast.next;
        }
        
        return fast;
    }
}