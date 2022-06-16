// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    {
        Node curr = head;
        Node lastNonNine = head;
        
        while (curr.next!=null) {
            curr=curr.next;
            if (curr.data!=9)
                lastNonNine = curr;
        }
        
        if (curr.data!=9) {
            curr.data+=1;
        }
        else {
            if (lastNonNine==head && head.data==9) {
                head = new Node(1);
                head.next=lastNonNine;
                lastNonNine.data=0;
            }
            else {
                lastNonNine.data+=1;
            }
            while (lastNonNine.next!=null) {
                lastNonNine = lastNonNine.next;
                lastNonNine.data=0;
            }
        }
        
        return head;
    }
}
