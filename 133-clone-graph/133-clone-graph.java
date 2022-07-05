/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    // Map to store node of graph to clone graph
    HashMap<Node,Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {  
        if (node==null)
            return node;

        Node copy = new Node(node.val);
        dfs(node,copy);
        return copy;
    }
    
    private void dfs(Node node,Node copy) {
        map.put(node,copy);
        
        for (Node n: node.neighbors) {
            if (!map.containsKey(n)) {
                Node newNode = new Node(n.val);
                dfs(n,newNode);
                copy.neighbors.add(newNode);
            }
            else {
                copy.neighbors.add(map.get(n));
            }
        }
    }
}