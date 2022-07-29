class Solution {
    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        
        // Create graph 
        for (int i=0;i<bombs.length;i++) {
            long x = bombs[i][0];
            long y = bombs[i][1];
            long r2 = (long) bombs[i][2]*bombs[i][2]; //Radius square 
            graph.put(i,new ArrayList<>());
            for (int j=0;j<bombs.length;j++) {
                if (i==j)
                    continue;
                
                long x1 = bombs[j][0];
                long y1 = bombs[j][1];
                if ((x-x1)*(x-x1)+(y-y1)*(y-y1) <= r2) {
                    graph.get(i).add(j);
                }
            }
        }
        
        // Apply BFS on each bomb
        int max = 0;
        for (int i=0;i<bombs.length;i++) {
            // BFS
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            boolean[] visited = new boolean[bombs.length];
            visited[i]=true;
            int detonate = 1; // Detonate current bomb
            
            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int neighbor: graph.get(curr)) {
                    if (!visited[neighbor]) {
                        visited[neighbor]=true;
                        detonate++;
                        q.add(neighbor);
                    }
                }
            }
            
            max = Math.max(max,detonate);
        }
        
        return max;
    }
}