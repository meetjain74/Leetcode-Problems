// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if (!isLeaf(node)) 
	        ans.add(node.data);
	    getLeftBoundaryNodes(ans,node);
	    getLeafNodes(ans,node);
	    getRightBoundaryNodes(ans,node);
	    return ans;
	}
	
	private boolean isLeaf(Node node) {
	    if (node.left==null && node.right==null)
	        return true;
        return false;
	}
	
	// Get left nodes excluding leaf nodes
	private void getLeftBoundaryNodes(ArrayList<Integer> ans,Node node) {
	    Node current = node.left;
	    while (current!=null) {
	        if (!isLeaf(current))
	            ans.add(current.data);
	        
	        if (current.left!=null)
	            current=current.left;
	        else
	            current=current.right;
	    }
	}
	
	// Get leaf nodes
	// Inorder traversal
	private void getLeafNodes(ArrayList<Integer> ans,Node node) {
	    if (node==null)
	        return;
	        
        getLeafNodes(ans,node.left);	        
	    if (isLeaf(node))
	        ans.add(node.data);
	    getLeafNodes(ans,node.right);  
	}
	
	// Get right nodes excluding leaf nodes in reverse order
	private void getRightBoundaryNodes(ArrayList<Integer> ans,Node node) {
	    ArrayList<Integer> temp = new ArrayList<>();
	    Node current = node.right;
	    while (current!=null) {
	        if (!isLeaf(current))
	            temp.add(current.data);
	        
	        if (current.right!=null)
	            current=current.right;
	        else
	            current=current.left;
	    }
	    
	    Collections.reverse(temp);
	    ans.addAll(temp);
	}
}
