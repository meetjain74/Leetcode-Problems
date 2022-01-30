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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode();
        ListNode current=result;
        int carry=0,temp;
        while (l1!=null && l2!=null)
        {
            temp=carry+l1.val+l2.val;
            current.val=temp%10;
            carry=temp/10;
                
            l1=l1.next;
            l2=l2.next;
            
            if (l1!=null || l2!=null || carry!=0)
                current.next=new ListNode();
            
            current=current.next;
        }
        while (l1!=null)
        {
            temp=carry+l1.val;
            current.val=temp%10;
            carry=temp/10;
            
            l1=l1.next;
            if (l1!=null || carry!=0)
                current.next=new ListNode();
            current=current.next;
        }
        while (l2!=null)
        {
            temp=carry+l2.val;
            current.val=temp%10;
            carry=temp/10;
            
            l2=l2.next;
            if (l2!=null || carry!=0)
                current.next=new ListNode();
            current=current.next;
        }
        
        if (carry!=0)
        {
            current.val=carry;
        }
        return result;
    }
}