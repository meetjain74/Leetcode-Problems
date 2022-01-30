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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedList = null;
        int length = lists.length;
        if (length==0)
            return null;
        else if (length==1)
            return lists[0];
        
        mergedList = mergeTwoLists(lists[0],lists[1]);
        
        for (int i=2;i<length;i++) {
            mergedList = mergeTwoLists(mergedList,lists[i]);
        }
        
        return mergedList;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = null;
        ListNode current = null;
        
        if (l1==null)
            return l2;
        else if (l2==null)
            return l1;
        
        while (l1!=null && l2!=null) {
            
            if (l1.val<l2.val) {
                if (mergedList==null) {
                    mergedList = new ListNode(l1.val);
                    current=mergedList;
                }
                else {
                    current.next = new ListNode(l1.val); 
                    current = current.next;
                }
                l1=l1.next;
            }
            else {
                if (mergedList==null) {
                    mergedList = new ListNode(l2.val);
                    current=mergedList;
                }
                else {
                    current.next = new ListNode(l2.val);
                    current = current.next;
                }
                l2=l2.next;
            }
        }
        
        while (l1!=null) {
            current.next = new ListNode(l1.val);
            current = current.next;
            l1=l1.next;
        }
        
        while (l2!=null) {
            current.next = new ListNode(l2.val);
            current = current.next;
            l2=l2.next;
        }
        
        return mergedList;
    }
}