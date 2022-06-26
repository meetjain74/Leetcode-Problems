/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head==null)
            return null;
        
        // Map to store corresponding nodes from original and duplicate
        HashMap<Node,Node> map = new HashMap<>();
        
        Node copy = new Node(head.val);
        Node currOriginal = head; // Current pointer of original list
        Node currDuplicate = copy; // Current pointer of duplicate list
        
        while (currOriginal!=null) {
            map.put(currOriginal,currDuplicate);
            currOriginal=currOriginal.next;
            if (currOriginal!=null) {
                currDuplicate.next=new Node(currOriginal.val);
            }
            currDuplicate=currDuplicate.next;
        }
        
        currOriginal = head;
        currDuplicate = copy;
        while (currOriginal!=null) {
            Node random = map.get(currOriginal.random);
            currDuplicate.random = random;
            currOriginal = currOriginal.next;
            currDuplicate=currDuplicate.next;
        }
        
        return copy;
    }
}