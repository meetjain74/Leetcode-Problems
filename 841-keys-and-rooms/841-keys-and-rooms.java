class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(); // No of rooms
        boolean[] visited = new boolean[n];
        
        //DFS
        dfs(rooms,visited,0);
        
        for (int i=0;i<n;i++) {
            if (!visited[i])
                return false;
        }
        
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms,boolean[] visited,int currRoom) {
        visited[currRoom]=true;
        for (Integer r: rooms.get(currRoom)) {
            if (!visited[r])
                dfs(rooms,visited,r);
        }
    }
}