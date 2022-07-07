class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        buildGraph(adjList,n,edges);
        
        // Find the centroid nodes of the graph
        return findCentroid(adjList,n);
    }
    
    private void buildGraph(List<List<Integer>> adjList,
                      int n, int[][] edges) {
        
        for (int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }
    
    private List<Integer> findCentroid(List<List<Integer>> adjList,int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] neighbors = new int[n]; // Count of neighbors of each node
        
        for (int i=0;i<n;i++) {
            neighbors[i]=adjList.get(i).size();
        }
        
        for (int i=0;i<n;i++) {
            if (neighbors[i]==1 || neighbors[i]==0)
                q.add(i);
        }
        
        // Trim the leaves until reaching the centroids
        int remainingNodes = n;
        while (remainingNodes>2) {
            // Remove the current layer of leaves
            int size = q.size();
            remainingNodes -= size;
            
            for (int i=0;i<size;i++) {
                int curr = q.poll();
                
                for (int neigh: adjList.get(curr)) {
                    neighbors[neigh]--;
                    if (neighbors[neigh]==1)
                        q.add(neigh);
                }
            }
        }
        
        List<Integer> centroids = new ArrayList<>();
        while (!q.isEmpty()) {
            centroids.add(q.poll());
        }
        return centroids;
    }
}