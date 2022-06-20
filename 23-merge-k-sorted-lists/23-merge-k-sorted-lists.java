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
        int k = lists.length;
        
        // Store all current first candidate of all the lists
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode node1,ListNode node2) {
                return node1.val-node2.val; // Ascending
            }
        });
        
        // Add first element of all lists
        for (int i=0;i<k;i++) {
            if (lists[i]!=null)
                pq.add(lists[i]);
        }
        
        ListNode ans = null;
        ListNode tail = ans;
        
        while (pq.size()!=0) {
            ListNode temp = pq.poll();
            if (temp.next!=null) {
                pq.add(temp.next);
            }
            
            if (ans==null) {
                tail=temp;
                ans=tail;
            }
            else {
                tail.next=temp;
                tail=tail.next;
            }    
        }
        
        return ans;
    }
}