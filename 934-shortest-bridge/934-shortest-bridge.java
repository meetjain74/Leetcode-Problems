class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        
        // BFS
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        // Add all nodes of one island first and then apply BFS
        // To find one island, apply DFS on any node with 1
        outer: for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]==1) {
                    dfs(grid,i,j,n,q,visited,dirs);
                    break outer;
                }
            }
        }
        
        // BFS to expand the island
        int flips = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-->0) {
                int[] curr = q.poll();
                for (int[] d: dirs) {
                    int i = curr[0]+d[0];
                    int j = curr[1]+d[1];
                    if (i>=0 && i<n && j>=0 && j<n && !visited[i][j]) {
                        if (grid[i][j]==1)
                            return flips;
                        q.add(new int[]{i,j});
                        visited[i][j]=true;
                    }
                }
            }
            flips++;
        }
        
        return -1;
    }
    
    private void dfs(int[][] grid,int i,int j,int n,
                    Queue<int[]> q,boolean[][] visited,int[][] dirs) {
        if (i<0 || j<0 || i>=n || j>=n || visited[i][j] || grid[i][j]==0)
            return;
        
        visited[i][j]=true;
        q.add(new int[]{i,j});
        for (int[] d: dirs) {
            dfs(grid,i+d[0],j+d[1],n,q,visited,dirs);
        }
    }
}