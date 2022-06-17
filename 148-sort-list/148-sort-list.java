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
    
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    // Sort using merge sort
    public ListNode mergeSort(ListNode head) {
        if (head==null || head.next==null)
            return head;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = slow;
        
        while (fast!=null && fast.next!=null) {
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        temp.next=null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return mergeList(l1,l2);
    }
    
    // Merge two sorted linked list
    public ListNode mergeList(ListNode l1,ListNode l2) {
        ListNode mergedList = new ListNode(-1); // Temporary node
        
        if (l1==null) return l2;
        if (l2==null) return l1;
        
        ListNode tail = mergedList;
        while (l1!=null && l2!=null) {
            if (l1.val<l2.val) {
                tail.next=l1;
                l1=l1.next;
            }
            else {
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        
        if (l1!=null)
            tail.next=l1;
        else
            tail.next=l2;
        
        return mergedList.next;
    }
    
    // Sort using quick sort
    // Time limit exceedes for this problem: 28/30 cases passed
    public ListNode quickSort(ListNode head) {
        quickSort(head,null);
        return head;
    }
    
    private void quickSort(ListNode head,ListNode tail) {
        if (head==tail)
            return;
        
        ListNode slow = head; // Find correct position for slow
        ListNode fast = head.next;
        int val = slow.val;
        
        while (fast!=tail) {
            if (fast.val<=val) {
                slow=slow.next;
                swap(slow,fast);
            }
            fast=fast.next;
        }
        swap(head,slow); // Now val at its correct position
        
        quickSort(head,slow);
        quickSort(slow.next,tail);
    }
    
    private void swap(ListNode node1, ListNode node2){
         int temp = node1.val;
         node1.val = node2.val;
         node2.val = temp;
    }
}