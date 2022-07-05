// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

class Node {
    int curr;
    int parent;
    
    Node(int curr,int parent) {
        this.curr=curr;
        this.parent=parent;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                if (checkCycle(adj,visited,i))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean checkCycle(ArrayList<ArrayList<Integer>> adj,
        boolean[] visited, int v) {
        
        // BFS
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(v,-1));
        visited[v]=true;
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            
            for (int i: adj.get(current.curr)) {
                if (!visited[i]) {
                    q.add(new Node(i,current.curr));
                    visited[i]=true;
                }
                else if (i!=current.parent) {
                    // Cycle exists
                    return true;
                }
            }
        }
        
        return false;
    }
}