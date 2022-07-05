// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] dfsVisit = new boolean[V];
        
        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                if (checkCycle(adj,visited,dfsVisit,i))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean checkCycle(ArrayList<ArrayList<Integer>> adj,
        boolean[] visited, boolean[] dfsVisit, int v) {
            
            // DFS
            visited[v]=true;
            dfsVisit[v]=true;
            
            for (int i: adj.get(v)) {
                if (!visited[i]) {
                    if (checkCycle(adj,visited,dfsVisit,i))
                        return true;
                }
                else if (dfsVisit[i]) {
                    // If visited node as well as present in dfsVisit- cycle exists
                    return true;
                }
            }
            dfsVisit[v]=false; // Mark false again while backtracking
            return false;
        }
}