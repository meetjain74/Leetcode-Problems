class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        buildGraph(adjList,numCourses,prerequisites);
        
        // detect cycle in directed graph 
        // If cycle exists - not possibe to finish all courses
        return !isCyclic(numCourses,adjList);
    }
    
    private void buildGraph(List<List<Integer>> adjList,
                      int numCourses, int[][] prerequisites) {
        
        for (int i=0;i<numCourses;i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] pair: prerequisites) {
            adjList.get(pair[1]).add(pair[0]);
        }
    }

    private boolean isCyclic(int V,List<List<Integer>> adj) {
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
    
    private boolean checkCycle(List<List<Integer>> adj,
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
                // If visited node as well as present in dfsVisit- 
                // cycle exists
                return true;
            }
        }
        dfsVisit[v]=false; // Mark false again while backtracking
        return false;
    }
}