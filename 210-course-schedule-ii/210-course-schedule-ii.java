class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        buildGraph(adjList,numCourses,prerequisites);
        
        return topoSort(adjList,numCourses);
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
    
    // Kahn's Algorithm
    private int[] topoSort(List<List<Integer>> adjList,int numCourses) {
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        
        for (int i=0;i<numCourses;i++) {
            for (int neigh: adjList.get(i))
                indegree[neigh]++;
        }
        
        // Add vertices with indegree 0 to queue
        for (int i=0;i<numCourses;i++) {
            if (indegree[i]==0)
                q.add(i);
        }
        
        // To store topo sort
        int[] topo = new int[numCourses];
        int index = 0;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            topo[index++]=curr;
            
            for (int neighbor: adjList.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor]==0)
                    q.add(neighbor);
            }
        }
        
        if (index!=numCourses)
            return new int[0];
        
        return topo;
    }
}