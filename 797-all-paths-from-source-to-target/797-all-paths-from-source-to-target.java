class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[0]=true;
        dfs(graph,ans,0,n-1,new ArrayList<>(),visited);
        return ans;
    }
    
    private void dfs(int[][] graph,List<List<Integer>> ans,int src,int dst,
                     List<Integer> temp,boolean[] visited) {
        temp.add(src);
        if (src==dst) {
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        
        for (int neighbor: graph[src]) {
            if (!visited[neighbor]) {
                visited[neighbor]=true;
                dfs(graph,ans,neighbor,dst,temp,visited);
                visited[neighbor]=false;
            }
        }
        
        temp.remove(temp.size()-1);
    }
}