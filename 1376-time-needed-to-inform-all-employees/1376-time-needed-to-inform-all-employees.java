class Pair {
    int id;
    int time; //inform time passed
    
    Pair(int id,int time) {
        this.id=id;
        this.time=time;
    }
}

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        buildGraph(n,manager);
        
        // Apply BFS
        int totalTime = 0;
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new Pair(headID,0));
        visited[headID]=true;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int currID = curr.id;
            int currTime = curr.time;
            totalTime = Math.max(totalTime,currTime);
            
            for (int child: graph.get(currID)) {
                if (!visited[child]) {
                    visited[child]=true;
                    q.add(new Pair(child,currTime+informTime[currID]));
                }
            }
        }
        
        return totalTime;
    }
    
    private void buildGraph(int n,int[] manager) {
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0;i<n;i++) {
            if (manager[i]!=-1)
                graph.get(manager[i]).add(i);
        }
    }
}