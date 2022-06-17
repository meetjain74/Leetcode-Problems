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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head; 
        int size=0; // Size of the linked list
        while(curr!=null) {
            curr=curr.next;
            size++;
        }
        
        int elem = size/k; // Each split atleast contains elem elements
        int extra = size%k; // The first extra splits contains 1 extra element each
        
        ListNode[] ans = new ListNode[k];
        curr = head;
        int index = 0;
        
        while (index!=k) {
            if (curr!=null) {
                ans[index++]=curr;
                int visited = 1;
                int needToVisit = elem + ( (extra<=0) ? 0 : 1 );
                while(visited!=needToVisit) {
                    curr=curr.next;
                    visited++;
                }
                
                if (curr!=null) {
                    ListNode temp = curr;
                    curr = curr.next;
                    temp.next=null;
                }
                
                extra--;
            }
            else {
                ans[index++]=null;
            }
        }
        
        return ans;
    }
}