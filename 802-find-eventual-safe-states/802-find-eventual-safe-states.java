class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean isSafe[] = new boolean[n];
        boolean visited[] = new boolean[n];
        
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                visited[i]=true;
                isSafe[i] = dfs(graph,i,visited,isSafe);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<n;i++) {
            if (isSafe[i])
                ans.add(i);
        }
        return ans;
    }
    
    private boolean dfs(int[][] graph,int curr,boolean[] visited,boolean[] isSafe) {
        boolean safe = true;
        for (int neigh: graph[curr]) {
            if (isSafe[neigh]) {
                continue;
            }
            
            if (!visited[neigh]) {
                visited[neigh]=true;
                boolean temp = dfs(graph,neigh,visited,isSafe);
                isSafe[neigh] = temp;
                safe = safe & temp;
            }
            else {
                isSafe[neigh] = false;
                safe = false;
                break;
            }
        }
        
        return safe;
    }
}