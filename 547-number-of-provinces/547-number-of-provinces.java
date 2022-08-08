class Solution {
    public int findCircleNum(int[][] isConnected) {
        // Given adjacency representation of graph
        // Find no of connected components
        
        int n = isConnected.length;
        int provinces=0;
        boolean[] visited = new boolean[n+1];
        
        for (int i=1;i<=n;i++) {
            if (!visited[i]) {
                visited[i]=true;
                dfs(isConnected,i,n,visited);
                provinces++;
            }
        }
        
        return provinces;
    }
    
    private void dfs(int[][] graph,int i,int n,boolean[] visited) {
        for (int j=1;j<=n;j++) {
            if (graph[i-1][j-1]==1 && !visited[j]) {
                visited[j]=true;
                dfs(graph,j,n,visited);
            }
        }
    }
}