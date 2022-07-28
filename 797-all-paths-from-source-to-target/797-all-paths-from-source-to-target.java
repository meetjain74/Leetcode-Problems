class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph,ans,0,n-1,path);
        return ans;
    }
    
    private void dfs(int[][] graph,List<List<Integer>> ans,int src,
                     int dst,List<Integer> path) {
        if (src==dst) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for (int neighbor: graph[src]) {
                path.add(neighbor);
                dfs(graph,ans,neighbor,dst,path);
                path.remove(path.size()-1);
        }
    }
}