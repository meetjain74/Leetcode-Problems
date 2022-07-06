class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        buildGraph(graph,n,dislikes);
        
        int[] color = new int[n+1];
        Arrays.fill(color,-1); // No color
        
        // Check if graph is bipartite
        for (int i=1;i<=n;i++) {
            if (color[i]==-1 && !bipartiteDFS(graph,color,i))
                return false;
        }
        
        return true;
    }
    
    private void buildGraph(List<List<Integer>> adjList,
                      int n, int[][] edges) {
        
        for (int i=0;i<=n;i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }
    
    private boolean bipartiteDFS(List<List<Integer>> graph,int[] color,int node) {
        if (color[node]==-1) {
            color[node]=1;
        }
     
        for (int neighbor: graph.get(node)) {
            if (color[neighbor]==-1) {
                // Neighbor not colored yet - Color opposite color
                color[neighbor]=1-color[node];
                if (!bipartiteDFS(graph,color,neighbor))
                    return false;
            }
            else if (color[neighbor]==color[node]) {
                // Same color to neighbor- not bipartite
                return false;
            }
        }
        
        return true;
    }
}