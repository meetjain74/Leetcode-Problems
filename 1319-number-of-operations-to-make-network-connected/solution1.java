class Solution {
    public int makeConnected(int n, int[][] connections) {
        // For n computers to form a network, require n-1 connections
        if (connections.length < n-1)
            return -1; // Enough connections not available
        
        List<List<Integer>> graph = new ArrayList<>(); // Adjacency list
        buildGraph(graph,connections,n);
        
        boolean[] visited = new boolean[n];
        
        int components = 0; // Find no of components in graph
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                components++;
                dfs(graph,visited,i);
            }
        }
        
        // no of connections required to make network connected
        return components-1;
    }
    
    private void buildGraph(List<List<Integer>> graph,int[][] connections,int n) {
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int[] c: connections) {
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(c[0]);
        }
    }
    
    private void dfs(List<List<Integer>> graph, boolean[] visited,int node) {
        if (visited[node])
            return;
        
        visited[node] = true;
        for (Integer neighbor: graph.get(node)) {
            dfs(graph,visited,neighbor);
        }
    }
}
