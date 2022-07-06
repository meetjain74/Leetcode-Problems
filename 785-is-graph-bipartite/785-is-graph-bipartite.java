class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1); // No color
        
        for (int i=0;i<n;i++) {
            if (color[i]==-1 && !bipartiteBFS(graph,color,i))
                return false;
        }
        
        return true;
    }
    
    private boolean bipartiteBFS(int[][] graph,int[] color,int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node]=1; // First color-1 and second color-0
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            // Get neighbors of curr
            for (int neighbor: graph[curr]) {
                if (color[neighbor]==-1) {
                    // Neighbor not colored yet - Color opposite color
                    color[neighbor]=1-color[curr];
                    q.add(neighbor);
                }
                else if (color[neighbor]==color[curr]) {
                    // Same color to neighbor- not bipartite
                    return false;
                }
            }
        }
        
        return true;
    }
}