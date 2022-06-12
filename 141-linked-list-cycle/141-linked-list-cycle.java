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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode curr=head;
        while (curr!=null) {
            if (nodes.contains(curr))
                return true;
            nodes.add(curr);
            curr=curr.next;
        }
        return false;
    }
}